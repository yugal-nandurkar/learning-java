package microteam.classloader.regular;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.net.URLClassLoader;

@Configuration
public class CustomClassLoaderConfig {

    @Bean
    public ClassLoader customClassLoader(ConfigurableBeanFactory beanFactory) {
        // Create a custom class loader
        ClassLoader customClassLoader = new URLClassLoader(new URL[] {
                // Specify your classpath URLs
        });
        // Set it as the default class loader for Spring
        beanFactory.setBeanClassLoader(customClassLoader);
        return customClassLoader;
    }
}

