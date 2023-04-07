package com.example.practicaltask;

import com.example.practicaltask.util.dataloader.DataLoader;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class TestContextBootstrapInitializer0 {
  public static void registerPracticaltaskApplication(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("practicaltaskApplication", PracticaltaskApplication.class)
        .instanceSupplier((instanceContext) -> {
          PracticaltaskApplication bean = new PracticaltaskApplication();
          instanceContext.field("dataLoader", DataLoader.class)
              .invoke(beanFactory, (attributes) -> {
                Field dataLoaderField = ReflectionUtils.findField(PracticaltaskApplication.class, "dataLoader", DataLoader.class);
                ReflectionUtils.makeAccessible(dataLoaderField);
                ReflectionUtils.setField(dataLoaderField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }
        }
