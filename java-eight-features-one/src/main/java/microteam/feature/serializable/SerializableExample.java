package microteam.feature.serializable;

import java.io.*;
import java.util.function.Function;

// Interface
interface MySerializableInterface extends Serializable {
    void hello(String name);
}

// Class 1: Helper class implementing the above interface
class MyImpl implements MySerializableInterface {
    @Override
    public void hello(String name) {
        System.out.println("Hello " + name);
    }
}

// Class 2: Main class for serialization and deserialization
public class SerializableExample {

    // Method 1: Serialize an object to a file
    private static void serialize(Object obj, String outputPath) throws IOException {
        File outputFile = new File(outputPath);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            outputStream.writeObject(obj);
        }
    }

    // Method 2: Deserialize an object from a file
    private static Object deserialize(String inputPath) throws IOException, ClassNotFoundException {
        File inputFile = new File(inputPath);
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(inputFile))) {
            return inputStream.readObject();
        }
    }

    // Method 3: Serialize and deserialize a lambda function
    private static void serializeAndDeserializeFunction() throws Exception {
        // Define a lambda function
        Function<Integer, String> fn = (Function<Integer, String> & Serializable) n -> "Hello " + n;

        System.out.println("Run original function: " + fn.apply(10));

        String path = "serialized-function.dat";

        // Serialize the lambda function
        serialize(fn, path);
        System.out.println("Serialized function to " + path);

        // Deserialize the lambda function
        @SuppressWarnings("unchecked")
        Function<Integer, String> deserializedFn = (Function<Integer, String>) deserialize(path);

        System.out.println("Deserialized function from " + path);
        System.out.println("Run deserialized function: " + deserializedFn.apply(11));
    }

    // Method 4: Serialize and deserialize a class
    private static void serializeAndDeserializeClass() throws Exception {
        String path = "serialized-class.dat";

        // Serialize the class
        serialize(MyImpl.class, path);
        System.out.println("Serialized class to " + path);

        // Deserialize the class
        @SuppressWarnings("unchecked")
        Class<?> myImplClass = (Class<?>) deserialize(path);

        System.out.println("Deserialized class from " + path);

        // Create an instance of the deserialized class
        MySerializableInterface instance = (MySerializableInterface) myImplClass.getDeclaredConstructor().newInstance();
        instance.hello("Java");
    }

    // Main method
    public static void main(String[] args) throws Exception {
        // Serialize and deserialize lambda functions
        serializeAndDeserializeFunction();

        // Serialize and deserialize classes
        serializeAndDeserializeClass();
    }
}
