package microteam.feature.cast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class LambdaCastConfig {

    @Bean
    public Function<String, String> castedLambda() {
        // Lambda cast: Explicitly tagging a lambda with a specific target type
        return (Function<String, String>) (input -> "Processed: " + input);
    }
}
