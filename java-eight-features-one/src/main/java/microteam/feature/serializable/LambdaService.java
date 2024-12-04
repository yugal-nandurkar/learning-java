package microteam.feature.serializable;

import org.springframework.stereotype.Service;

@Service
public class LambdaService {

    public SerializableFunction<String, String> createLambda(String prefix) {
        // Captures the lexical scope variable 'prefix'
        return (SerializableFunction<String, String>) input -> prefix + ": " + input;
    }
}

