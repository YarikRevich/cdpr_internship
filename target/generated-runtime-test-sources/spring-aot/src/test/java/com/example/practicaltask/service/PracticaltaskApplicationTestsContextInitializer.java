package com.example.practicaltask.service;

import com.example.practicaltask.dao.ProductDao;
import com.example.practicaltask.dao.TransactionDao;
import com.example.practicaltask.dao.UserDao;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class PracticaltaskApplicationTestsContextInitializer {
  public static void registerProductService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("productService", ProductService.class)
        .instanceSupplier((instanceContext) -> {
          ProductService bean = new ProductService();
          instanceContext.field("productDao", ProductDao.class)
              .invoke(beanFactory, (attributes) -> {
                Field productDaoField = ReflectionUtils.findField(ProductService.class, "productDao", ProductDao.class);
                ReflectionUtils.makeAccessible(productDaoField);
                ReflectionUtils.setField(productDaoField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }

          public static void registerTransactionService(DefaultListableBeanFactory beanFactory) {
            BeanDefinitionRegistrar.of("transactionService", TransactionService.class)
                .instanceSupplier((instanceContext) -> {
                  TransactionService bean = new TransactionService();
                  instanceContext.field("transactionDao", TransactionDao.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field transactionDaoField = ReflectionUtils.findField(TransactionService.class, "transactionDao", TransactionDao.class);
                        ReflectionUtils.makeAccessible(transactionDaoField);
                        ReflectionUtils.setField(transactionDaoField, bean, attributes.get(0));
                      });
                          instanceContext.field("userDao", UserDao.class)
                              .invoke(beanFactory, (attributes) -> {
                                Field userDaoField = ReflectionUtils.findField(TransactionService.class, "userDao", UserDao.class);
                                ReflectionUtils.makeAccessible(userDaoField);
                                ReflectionUtils.setField(userDaoField, bean, attributes.get(0));
                              });
                                  instanceContext.field("productDao", ProductDao.class)
                                      .invoke(beanFactory, (attributes) -> {
                                        Field productDaoField = ReflectionUtils.findField(TransactionService.class, "productDao", ProductDao.class);
                                        ReflectionUtils.makeAccessible(productDaoField);
                                        ReflectionUtils.setField(productDaoField, bean, attributes.get(0));
                                      });
                                          return bean;
                                        }).register(beanFactory);
                                  }

                                  public static void registerUserService(
                                      DefaultListableBeanFactory beanFactory) {
                                    BeanDefinitionRegistrar.of("userService", UserService.class)
                                        .instanceSupplier((instanceContext) -> {
                                          UserService bean = new UserService();
                                          instanceContext.field("userDao", UserDao.class)
                                              .invoke(beanFactory, (attributes) -> {
                                                Field userDaoField = ReflectionUtils.findField(UserService.class, "userDao", UserDao.class);
                                                ReflectionUtils.makeAccessible(userDaoField);
                                                ReflectionUtils.setField(userDaoField, bean, attributes.get(0));
                                              });
                                                  return bean;
                                                }).register(beanFactory);
                                          }
                                        }
