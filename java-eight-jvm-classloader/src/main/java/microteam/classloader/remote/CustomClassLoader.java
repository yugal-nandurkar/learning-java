package microteam.classloader.remote;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class CustomClassLoader extends ClassLoader {

    private final String remoteServerBaseUrl;

    public CustomClassLoader(String remoteServerBaseUrl) {
        this.remoteServerBaseUrl = remoteServerBaseUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            // Construct the URL to fetch the bytecode
            String classFileName = name.replace('.', '/') + ".class";
            URL url = new URL(remoteServerBaseUrl + classFileName);

            // Fetch the bytecode via HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() != 200) {
                throw new ClassNotFoundException("Class not found at remote server: " + name);
            }

            try (InputStream inputStream = connection.getInputStream()) {
                byte[] byteCode = inputStream.readAllBytes();

                // Define the class using the parent ClassLoader method
                return defineClass(name, byteCode, 0, byteCode.length);
            }
        } catch (Exception e) {
            throw new ClassNotFoundException("Failed to load class: " + name, e);
        }
    }
}
