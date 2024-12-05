package microteam.classloader.remote;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

import microteam.classloader.remote.CustomClassLoader;

@Service
public class AppletManager {

    private final ConcurrentHashMap<String, Object> loadedApplets = new ConcurrentHashMap<>();
    private final String remoteServerBaseUrl = "http://example.com/classes/";

    public Object loadApplet(String appletName) {
        try {
            // Create a new instance of the CustomClassLoader for each applet
            CustomClassLoader classLoader = new CustomClassLoader(remoteServerBaseUrl);

            // Load the class by name
            Class<?> appletClass = classLoader.loadClass(appletName);

            // Create an instance of the applet
            Object appletInstance = appletClass.getDeclaredConstructor().newInstance();

            // Cache the instance for future use
            loadedApplets.put(appletName, appletInstance);
            return appletInstance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load applet: " + appletName, e);
        }
    }

    public Object getApplet(String appletName) {
        return loadedApplets.get(appletName);
    }
}

