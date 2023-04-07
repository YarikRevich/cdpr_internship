package com.example.practicaltask.controller;

import com.example.practicaltask.service.ProductService;
import com.example.practicaltask.service.TransactionService;
import com.example.practicaltask.service.UserService;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class PracticaltaskApplicationTestsContextInitializer {
  public static void registerProductController(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("productController", ProductController.class)
        .instanceSupplier((instanceContext) -> {
          ProductController bean = new ProductController();
          instanceContext.field("productService", ProductService.class)
              .invoke(beanFactory, (attributes) -> {
                Field productServiceField = ReflectionUtils.findField(ProductController.class, "productService", ProductService.class);
                ReflectionUtils.makeAccessible(productServiceField);
                ReflectionUtils.setField(productServiceField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }

          public static void registerTransactionController(DefaultListableBeanFactory beanFactory) {
            BeanDefinitionRegistrar.of("transactionController", TransactionController.class)
                .instanceSupplier((instanceContext) -> {
                  TransactionController bean = new TransactionController();
                  instanceContext.field("transactionService", TransactionService.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field transactionServiceField = ReflectionUtils.findField(TransactionController.class, "transactionService", TransactionService.class);
                        ReflectionUtils.makeAccessible(transactionServiceField);
                        ReflectionUtils.setField(transactionServiceField, bean, attributes.get(0));
                      });
                          return bean;
                        }).register(beanFactory);
                  }

                  public static void registerUserController(
                      DefaultListableBeanFactory beanFactory) {
                    BeanDefinitionRegistrar.of("userController", UserController.class)
                        .instanceSupplier((instanceContext) -> {
                          UserController bean = new UserController();
                          instanceContext.field("userService", UserService.class)
                              .invoke(beanFactory, (attributes) -> {
                                Field userServiceField = ReflectionUtils.findField(UserController.class, "userService", UserService.class);
                                ReflectionUtils.makeAccessible(userServiceField);
                                ReflectionUtils.setField(userServiceField, bean, attributes.get(0));
                              });
                                  return bean;
                                }).register(beanFactory);
                          }
                        }
