package microteam.feature.cast;

//package com.example;

import microteam.feature.cast.MyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CastApplicationRunner  implements CommandLineRunner {

    @Override
    public void run(String... args) {
        // Initialize the Spring application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the bean from the context (cast required for type safety)
        Object bean = context.getBean("myService");
        MyService myService = (MyService) bean; // Explicit cast

        // Use the bean
        myService.performTask();
    }
}
