package microteam.classloader.versioned;

public class ClassLoaderService {
    private CustomClassLoader customClassLoader;

    public void setCustomClassLoader(CustomClassLoader customClassLoader) {
        this.customClassLoader = customClassLoader;
    }

    public void loadDynamicClass(String className) {
        try {
            // Dynamically load a class
            Class<?> loadedClass = customClassLoader.findClass(className);
            System.out.println("Class Loaded: " + loadedClass.getName());

            // Instantiate and invoke methods dynamically (for example, JDBC drivers)
            Object instance = loadedClass.getDeclaredConstructor().newInstance();
            System.out.println("Instance created: " + instance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
