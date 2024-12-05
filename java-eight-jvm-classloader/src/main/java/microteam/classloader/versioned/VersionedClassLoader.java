package microteam.classloader.versioned;

import java.net.URL;
import java.net.URLClassLoader;

public class VersionedClassLoader extends URLClassLoader {

    public VersionedClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public void loadClassVersion(String className, String version) {
        try {
            // Modify URL to point to versioned JARs or class locations
            URL jarUrl = new URL("file:/path/to/jars/" + version + "/" + className + ".jar");
            addURL(jarUrl);

            // Load class from the specified JAR
            Class<?> loadedClass = loadClass(className);
            System.out.println("Versioned Class Loaded: " + loadedClass.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

