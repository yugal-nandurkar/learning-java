package microteam.feature.serializable;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.interceptor.KeyGenerator;

import java.io.*;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public KeyGenerator serializableKeyGenerator() {
        // A serializable lambda for generating cache keys
        SerializableFunction<Object[], String> keyGenerator = args -> {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(args);
                oos.close();
                return baos.toString();
            } catch (IOException e) {
                throw new RuntimeException("Error generating cache key", e);
            }
        };

        return (target, method, params) -> keyGenerator.apply(params);
    }
}
