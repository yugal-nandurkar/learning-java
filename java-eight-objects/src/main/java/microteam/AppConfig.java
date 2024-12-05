package microteam;

import microteam.access_modifiers.PrivateService;
import microteam.access_modifiers.ProtectedService;
import microteam.access_modifiers.PublicService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomObject customObject() {
        return new CustomObject("Custom Value");
    }

    @Bean
    public PublicService publicService() {
        return new PublicService();
    }

    @Bean
    protected ProtectedService protectedService() {
        return new ProtectedService();
    }

    @Bean
    protected PrivateService privateService() {
        return new PrivateService();
    }
}

