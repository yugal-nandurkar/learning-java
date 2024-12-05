package microteam.classloader.dynamic;

import org.springframework.stereotype.Service;

import java.net.URL;
import java.net.URLClassLoader;

@Service
public class DynamicClassService {

    public void loadAndRunDynamicClass() throws Exception {
        // Path to the directory containing MyDynamicClass.class
        URL[] urls = { new URL("file:/path/to/classes/") };

        // Create a custom class loader
        ClassLoader customClassLoader = new URLClassLoader(urls);

        // Dynamically load the class
        Class<?> clazz = customClassLoader.loadClass("microteam.classloader.dynamic.MyDynamicClass");

        // Instantiate the loaded class
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // Invoke a method
        clazz.getMethod("sayHello").invoke(instance);
    }
}

