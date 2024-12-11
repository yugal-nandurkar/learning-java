package microteam.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApp implements CommandLineRunner {

    @Autowired
    private StringService stringService;

    @Autowired
    private ValueStringService valueStringService;

    @Autowired
    private String greetingMessage;  // Injected via @Bean in AppConfig

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Output from StringService (initialized in the constructor)
        System.out.println(stringService.getGreeting());

        // Output from ValueStringService (initialized via @Value from application.properties)
        System.out.println(valueStringService.getGreetingMessage());

        // Output from @Bean in AppConfig (initialized via @Bean in configuration class)
        System.out.println(greetingMessage);
    }
}

