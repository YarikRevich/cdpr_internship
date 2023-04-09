package com.gamestore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.micrometer.core.lang.NonNull;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "cartItems")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User user;
 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "games_id")
    private Game game;

    @Column(nullable = false)
    private int quantity;

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Game getGame(){
        return this.game;
    }

    public void setGame(Game game){
        this.game = game;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
