package microteam.classloader.dynamic;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.net.URLClassLoader;

@Service
public class DynamicBeanLoader {

    private final ApplicationContext context;

    public DynamicBeanLoader(ApplicationContext context) {
        this.context = context;
    }

    public void loadAndRegisterBean() throws Exception {
        // Path to the directory containing MyBean.class
        URL[] urls = { new URL("file:/path/to/classes/") };

        // Create a custom class loader
        ClassLoader customClassLoader = new URLClassLoader(urls);

        // Dynamically load the MyBean class
        Class<?> clazz = customClassLoader.loadClass("microteam.classloader.regular.MyBean");

        // Register MyBean in the Spring context
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ((AnnotationConfigApplicationContext) context).getBeanFactory();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(clazz);
        beanFactory.registerBeanDefinition("myDynamicBean", beanDefinition);
    }
}

