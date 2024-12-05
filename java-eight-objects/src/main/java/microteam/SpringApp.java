package microteam;

import microteam.access_modifiers.DefaultService;
import microteam.access_modifiers.PrivateService;
import microteam.access_modifiers.ProtectedService;
import microteam.access_modifiers.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApp implements CommandLineRunner {

    @Autowired
    private PublicService publicService;

    @Autowired
    private ProtectedService protectedService;

    @Autowired
    private PrivateService privateService;

    @Autowired
    private DefaultService defaultService;

    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Test PublicService (Accessible everywhere)
        System.out.println(publicService.getGreeting("John"));

        // Test ProtectedService (Accessible within same package)
        System.out.println(protectedService.getGreeting("Jane"));

        // Test PrivateService (Invoke through a public method)
        System.out.println(privateService.invokeGreeting("Jake"));

        // Test DefaultService (Package-private, accessible within the same package)
        System.out.println(defaultService.getGreeting("Jill"));
    }
}


