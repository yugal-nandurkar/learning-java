package microteam.new_features.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private Java8FeaturesService service;

    @Override
    public void run(String... args) {
        // Lambda Expressions Example
        System.out.println("Filtered Strings (Lambda): " + service.filterStringsUsingLambda(Arrays.asList("Java", "Spring", "Node")));

        // Method References Example
        System.out.println("String Lengths (Method Reference): " + service.mapStringsToLengthsUsingMethodReference(Arrays.asList("Java", "Spring", "Node")));

        // Optional Example
        System.out.println("Optional Value: " + service.getOptionalValue(Optional.of("Present Value")));
        System.out.println("Optional Default: " + service.getOptionalValue(Optional.empty()));

        // Functional Interface Example
        System.out.println("Greeting: " + service.greet("World"));

        // Default Methods Example
        System.out.println("Calculator: " + service.calculate());

        // Nashorn Example
        System.out.println("Nashorn JS Result: " + service.evaluateJavaScript("3 + 4"));

        // Stream API Example
        System.out.println("Processed Stream: " + service.processStream(Arrays.asList("Java", "Spring", "Angular", "Node")));

        // Date API Example
        System.out.println("Current DateTime: " + service.getCurrentDateTime());
        System.out.println("Parsed Date: " + service.parseDate("2024-12-06"));
    }
}

