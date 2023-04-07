package com.example.practicaltask.util.dataloader;

import com.example.practicaltask.dao.ProductDao;
import com.example.practicaltask.dao.UserDao;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class PracticaltaskApplicationTestsContextInitializer {
  public static void registerDataLoader(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("dataLoader", DataLoader.class)
        .instanceSupplier((instanceContext) -> {
          DataLoader bean = new DataLoader();
          instanceContext.field("productDao", ProductDao.class)
              .invoke(beanFactory, (attributes) -> {
                Field productDaoField = ReflectionUtils.findField(DataLoader.class, "productDao", ProductDao.class);
                ReflectionUtils.makeAccessible(productDaoField);
                ReflectionUtils.setField(productDaoField, bean, attributes.get(0));
              });
                  instanceContext.field("userDao", UserDao.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field userDaoField = ReflectionUtils.findField(DataLoader.class, "userDao", UserDao.class);
                        ReflectionUtils.makeAccessible(userDaoField);
                        ReflectionUtils.setField(userDaoField, bean, attributes.get(0));
                      });
                          return bean;
                        }).register(beanFactory);
                  }
                }
