package com.example.practicaltask.dao;

import com.example.practicaltask.repository.ProductRepository;
import com.example.practicaltask.repository.UserRepository;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class TestContextBootstrapInitializer0 {
  public static void registerProductDao(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("com.example.practicaltask.dao.ProductDao", ProductDao.class)
        .instanceSupplier((instanceContext) -> {
          ProductDao bean = new ProductDao();
          instanceContext.field("productRepository", ProductRepository.class)
              .invoke(beanFactory, (attributes) -> {
                Field productRepositoryField = ReflectionUtils.findField(ProductDao.class, "productRepository", ProductRepository.class);
                ReflectionUtils.makeAccessible(productRepositoryField);
                ReflectionUtils.setField(productRepositoryField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }

          public static void registerUserDao(DefaultListableBeanFactory beanFactory) {
            BeanDefinitionRegistrar.of("com.example.practicaltask.dao.UserDao", UserDao.class)
                .instanceSupplier((instanceContext) -> {
                  UserDao bean = new UserDao();
                  instanceContext.field("userRepository", UserRepository.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field userRepositoryField = ReflectionUtils.findField(UserDao.class, "userRepository", UserRepository.class);
                        ReflectionUtils.makeAccessible(userRepositoryField);
                        ReflectionUtils.setField(userRepositoryField, bean, attributes.get(0));
                      });
                          return bean;
                        }).register(beanFactory);
                  }
                }
