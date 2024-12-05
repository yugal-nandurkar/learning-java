package microteam.classloader.regular;

import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoaderExample {

    public static void main(String[] args) throws Exception {
        // Define the location of the class file
        URL[] urls = { new URL("file:/path/to/classes/") };

        // Create a custom class loader
        ClassLoader customClassLoader = new URLClassLoader(urls);

        // Load a class dynamically
        Class<?> loadedClass = customClassLoader.loadClass("microteam.classloader.dynamic.MyDynamicClass");

        // Instantiate the loaded class
        Object instance = loadedClass.getDeclaredConstructor().newInstance();
        System.out.println("Loaded class: " + loadedClass.getName());
    }
}
