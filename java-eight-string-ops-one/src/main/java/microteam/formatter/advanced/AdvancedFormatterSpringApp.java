package microteam.formatter.advanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvancedFormatterSpringApp implements CommandLineRunner {

    @Autowired
    private AdvancedFormatterService formatterService;

    public static void main(String[] args) {
        SpringApplication.run(AdvancedFormatterSpringApp.class, args);
    }

    @Override
    public void run(String... args) {
        // Advanced formatting using argument index, precision, and flags
        String advancedFormatted = formatterService.advancedFormat(
                "Formatted String: %2$s is before %1$s. Value: %+.2f%n",
                "Alice", "Bob", 123.456
        );
        System.out.println(advancedFormatted);

        // Using Appendable with Formatter
        StringBuilder appendableResult = new StringBuilder();
        formatterService.formatToAppendable(appendableResult, "Hello, %s! You scored %.1f points.%n", "John", 95.5);
        System.out.println("Appendable Result:\n" + appendableResult);

        // Demonstrate advanced features
        String advancedFeaturesDemo = formatterService.demonstrateAdvancedFeatures();
        System.out.println("Advanced Features Demonstration:\n" + advancedFeaturesDemo);
    }
}
