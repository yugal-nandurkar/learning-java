package microteam.feature.cast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumericCastConfig {

    @Bean
    public Double castedDoubleValue() {
        // Numeric cast: int to double
        int intValue = 42;
        return (double) intValue; // Cast to double
    }

    @Bean
    public int castedIntValue() {
        // Numeric cast: float to int
        float floatValue = 42.8f;
        return (int) floatValue; // Cast to int (truncation occurs)
    }
}

