package microteam.classloader.custom;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import microteam.classloader.custom.CustomClassLoader ;

public class CustomSpringApp  {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Retrieve the CustomClassLoader bean
        CustomClassLoader customClassLoader = context.getBean("customClassLoader", CustomClassLoader.class);

        try {
            // Dynamically load a class (for example: com.example.MyClass)
            Class<?> loadedClass = customClassLoader.findClass("microteam.classloader.dynamic.MyDynamicClass");

            // Print information about the dynamically loaded class
            System.out.println("Class Loaded: " + loadedClass.getName());
            System.out.println("Class Loader: " + loadedClass.getClassLoader());

            // Instantiate the dynamically loaded class
            Object instance = loadedClass.getDeclaredConstructor().newInstance();
            System.out.println("Instance created: " + instance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        ((ClassPathXmlApplicationContext) context).close();
    }
}
