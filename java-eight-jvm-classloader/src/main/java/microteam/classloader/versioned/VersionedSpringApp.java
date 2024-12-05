package microteam.classloader.versioned;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import microteam.classloader.versioned.ClassLoaderService ;

public class VersionedSpringApp{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Use the ClassLoaderService bean
        ClassLoaderService classLoaderService = context.getBean("classLoaderService", ClassLoaderService.class);

        // Dynamically load a class
        classLoaderService.loadDynamicClass("microteam.classloader.dynamic.MyDynamicClass");

        ((ClassPathXmlApplicationContext) context).close();
    }
}

