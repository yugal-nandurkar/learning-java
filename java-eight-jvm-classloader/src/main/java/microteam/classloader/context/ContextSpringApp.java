package microteam.classloader.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import microteam.classloader.context.ContextClassLoaderService;

public class ContextSpringApp {

    public static void main(String[] args) {
        // Load the Spring context from the configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get the context class loader service bean
        ContextClassLoaderService classLoaderService = context.getBean("contextClassLoaderService", ContextClassLoaderService.class);

        // Example of loading a class in the current thread's context
        classLoaderService.loadClassInCurrentThreadContext("microteam.classloader.dynamic.MyDynamicClass");

        // Close the context when done
        ((ClassPathXmlApplicationContext) context).close();
    }
}

