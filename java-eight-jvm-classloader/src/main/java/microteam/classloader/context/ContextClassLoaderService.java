package microteam.classloader.context;

public class ContextClassLoaderService {

    private MyCustomClassLoader contextClassLoader;

    // Set the context class loader (injecting the custom class loader bean)
    public void setContextClassLoader(MyCustomClassLoader contextClassLoader) {
        this.contextClassLoader = contextClassLoader;
    }

    public void loadClassInCurrentThreadContext(String className) {
        // Save the current context class loader
        ClassLoader originalClassLoader = Thread.currentThread().getContextClassLoader();

        // Set the context class loader to our custom loader
        Thread.currentThread().setContextClassLoader(this.contextClassLoader);

        try {
            // Load the class dynamically using the context class loader
            Class<?> loadedClass = Class.forName(className);
            System.out.println("Class loaded: " + loadedClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Restore the original context class loader
            Thread.currentThread().setContextClassLoader(originalClassLoader);
        }
    }
}

