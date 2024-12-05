package microteam.feature.serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LambdaApplicationRunner implements CommandLineRunner {

    @Autowired
    private LambdaService lambdaService;

    @Override
    public void run(String... args) {
        // Create a lambda capturing the lexical scope variable
        String prefix = "Hello";
        SerializableFunction<String, String> lambda = lambdaService.createLambda(prefix);

        // Serialize the lambda
        byte[] serializedLambda = LambdaSerializationUtil.serialize(lambda);
        System.out.println("Lambda serialized successfully!");

        // Deserialize the lambda
        SerializableFunction<String, String> deserializedLambda =
                LambdaSerializationUtil.deserialize(serializedLambda);

        // Use the deserialized lambda
        String result = deserializedLambda.apply("World");
        System.out.println("Deserialized Lambda Result: " + result);
    }
}

