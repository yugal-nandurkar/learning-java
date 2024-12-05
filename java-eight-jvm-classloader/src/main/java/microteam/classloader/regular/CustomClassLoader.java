package microteam.classloader.regular;

import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader extends URLClassLoader {
    public CustomClassLoader(URL[] urls) {
        super(urls);
    }

    public static void main(String[] args) throws Exception {
        // Path to the directory containing MyDynamicClass.class
        URL[] urls = { new URL("file:/path/to/classes/") };

        // Create a custom class loader
        CustomClassLoader customClassLoader = new CustomClassLoader(urls);

        // Load MyDynamicClass dynamically
        Class<?> clazz = customClassLoader.loadClass("microteam.classloader.dynamic.MyDynamicClass");
        Object instance = clazz.getDeclaredConstructor().newInstance();

        // Invoke the method
        clazz.getMethod("sayHello").invoke(instance);
    }
}

