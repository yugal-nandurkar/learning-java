package microteam.apache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApacheSpringApp implements CommandLineRunner {

    @Autowired
    private RandomStringService randomStringService;

    public static void main(String[] args) {
        SpringApplication.run(ApacheSpringApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Generate and print random strings
        System.out.println("Random Alphanumeric String (10 chars): " + randomStringService.generateRandomAlphanumeric(10));
        System.out.println("Random Alphabetic String (8 chars): " + randomStringService.generateRandomAlphabetic(8));
        System.out.println("Random Numeric String (6 chars): " + randomStringService.generateRandomNumeric(6));
        System.out.println("Random Custom String (5 chars): " + randomStringService.generateRandomCustom(5, "abc123"));
    }
}

