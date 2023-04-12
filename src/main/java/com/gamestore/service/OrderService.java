package com.gamestore.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.gamestore.dao.CartDAO;
import com.gamestore.dao.OrderDAO;
import com.gamestore.dto.CartItemRetrievalResponseDTO;
import com.gamestore.dto.CartRetrievalResponseDTO;
import com.gamestore.dto.GameRetrievalResponseDTO;
import com.gamestore.dto.GenreRetrievalResponseDTO;
import com.gamestore.dto.OrderCreationRequestDTO;
import com.gamestore.dto.OrderCreationResponseDTO;
import com.gamestore.dto.OrderDeleteRequestDTO;
import com.gamestore.dto.OrderRetrievalRequestDTO;
import com.gamestore.dto.OrderRetrievalResponseDTO;
import com.gamestore.dto.UserRetrievalResponseDTO;
import com.gamestore.entity.Cart;
import com.gamestore.entity.Order;
import com.gamestore.exception.AlreadyExistsException;
import com.gamestore.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDao;

    @Autowired
    private CartDAO cartDao;

    public OrderCreationResponseDTO create(OrderCreationRequestDTO orderCreationRequestDto) throws AlreadyExistsException, NotFoundException {
        if (this.cartDao.existsById(orderCreationRequestDto.getCartId())){
            Cart cart = cartDao.getById(orderCreationRequestDto.getCartId());
            if (!this.orderDao.existsByCart(cart)){
                Order order = new Order();
                order.setCart(cart);
                order.setCreationTime(LocalDateTime.now());
                
                long id = this.orderDao.save(order);

                OrderCreationResponseDTO orderCreationResponseDto = new OrderCreationResponseDTO();
                orderCreationResponseDto.setId(id);

                return orderCreationResponseDto;
            } else {
                throw new AlreadyExistsException("Order for the given cart already exists");
            }
        } else {
            throw new NotFoundException("Cart with the given id does not exist");
        }
    }

    public OrderRetrievalResponseDTO get(OrderRetrievalRequestDTO orderRetrievalRequestDto) throws NotFoundException {
        // TODO: implement this
        return null;
    }

    public List<OrderRetrievalResponseDTO> getAll(){
        List<Order> orders = this.orderDao.getAll();

        return orders.stream()
        .map(order -> new OrderRetrievalResponseDTO(
            order.getId(), 
            new CartRetrievalResponseDTO(
                order.getCart().getId(),
                new UserRetrievalResponseDTO(
                    order.getCart().getUser().getId(), 
                    order.getCart().getUser().getFirstName(),
                    order.getCart().getUser().getLastName(),
                    order.getCart().getUser().getEmail(),
                    order.getCart().getUser().getPassword()
                ),
                order.getCart().getCartItems().stream()
                .map(cartItem -> new CartItemRetrievalResponseDTO(
                    cartItem.getId(),
                    new UserRetrievalResponseDTO(
                        cartItem.getUser().getId(), 
                        cartItem.getUser().getFirstName(),
                        cartItem.getUser().getLastName(),
                        cartItem.getUser().getEmail(),
                        cartItem.getUser().getPassword()
                    ),
                    new GameRetrievalResponseDTO(
                        cartItem.getGame().getId(), 
                        cartItem.getGame().getName(), 
                        cartItem.getGame().getGenres().stream().map(genre -> new GenreRetrievalResponseDTO(
                            genre.getId(), 
                            genre.getName()))
                        .collect(Collectors.toList()), 
                        cartItem.getGame().getPrice(), 
                        cartItem.getGame().getAvailableQuantity()
                    ),
                    cartItem.getQuantity()))
                .collect(Collectors.toList())
            ),
            order.getCreationTime()))
        .collect(Collectors.toList());
    }

    public void delete(OrderDeleteRequestDTO orderDeleteRequestDto)throws NotFoundException {
        if (this.orderDao.existsById(orderDeleteRequestDto.getId())){
            this.orderDao.delete(orderDeleteRequestDto.getId());
        } else {
            throw new NotFoundException("Order with the given id does not exist");
        }   
    } 
}
