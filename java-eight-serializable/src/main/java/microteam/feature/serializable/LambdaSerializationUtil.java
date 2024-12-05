package microteam.feature.serializable;

import java.io.*;

public class LambdaSerializationUtil {

    // Serialize a lambda to a byte array
    public static <T extends Serializable> byte[] serialize(T lambda) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(lambda);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize lambda", e);
        }
    }

    // Deserialize a lambda from a byte array
    public static <T> T deserialize(byte[] data) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to deserialize lambda", e);
        }
    }
}

