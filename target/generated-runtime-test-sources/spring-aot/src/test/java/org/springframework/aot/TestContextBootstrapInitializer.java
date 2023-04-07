package org.springframework.aot;

import java.lang.Class;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.aot.test.boot.AotSpringBootConfigContextLoader;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.test.context.SmartContextLoader;

public class TestContextBootstrapInitializer {
  public static Map<String, Supplier<SmartContextLoader>> getContextLoaders() {
    Map<String, Supplier<SmartContextLoader>> entries = new HashMap<>();
    entries.put("com.example.practicaltask.PracticaltaskApplicationTests", () -> new AotSpringBootConfigContextLoader(PracticaltaskApplicationTestsContextInitializer.class, WebApplicationType.SERVLET, SpringBootTest.WebEnvironment.MOCK));
    entries.put("com.example.practicaltask.dao.ProductDaoTests", () -> new AotSpringBootConfigContextLoader(TestContextBootstrapInitializer0.class));
    entries.put("com.example.practicaltask.dao.UserDaoTests", () -> new AotSpringBootConfigContextLoader(TestContextBootstrapInitializer0.class));
    entries.put("com.example.practicaltask.dao.TransactionDaoTests", () -> new AotSpringBootConfigContextLoader(TransactionDaoTestsContextInitializer.class));
    return entries;
  }

  public static Map<String, Class<? extends ApplicationContextInitializer<?>>> getContextInitializers(
      ) {
    Map<String, Class<? extends ApplicationContextInitializer<?>>> entries = new HashMap<>();
    entries.put("com.example.practicaltask.PracticaltaskApplicationTests", PracticaltaskApplicationTestsContextInitializer.class);
    entries.put("com.example.practicaltask.dao.ProductDaoTests", TestContextBootstrapInitializer0.class);
    entries.put("com.example.practicaltask.dao.UserDaoTests", TestContextBootstrapInitializer0.class);
    entries.put("com.example.practicaltask.dao.TransactionDaoTests", TransactionDaoTestsContextInitializer.class);
    return entries;
  }
}
