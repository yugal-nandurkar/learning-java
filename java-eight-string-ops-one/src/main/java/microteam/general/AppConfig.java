package microteam.general;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String greetingMessage() {
        return "Hello from @Configuration Bean!";
    }
}

