package microteam.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormatterSpringApp implements CommandLineRunner {

    @Autowired
    private FormatterService formatterService;

    public static void main(String[] args) {
        SpringApplication.run(FormatterSpringApp.class, args);
    }

    @Override
    public void run(String... args) {
        // Example 1: General formatting
        String formattedString = formatterService.formatString("Hello, %s! You have %d new messages.", "Alice", 5);
        System.out.println(formattedString);

        // Example 2: Currency formatting
        String formattedCurrency = formatterService.formatCurrency(12345.678);
        System.out.println("Formatted Currency: " + formattedCurrency);

        // Example 3: Date formatting (using `java.util.Date`)
        String formattedDate = formatterService.formatDate("%tB %te, %tY", new java.util.Date());
        System.out.println("Formatted Date: " + formattedDate);
    }
}

