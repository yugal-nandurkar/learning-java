package microteam.new_features.general;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Java8FeaturesService {

    // Lambda Expressions Example
    public List<String> filterStringsUsingLambda(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("J")) // Lambda Expression
                .collect(Collectors.toList());
    }

    // Method References Example
    public List<Integer> mapStringsToLengthsUsingMethodReference(List<String> strings) {
        return strings.stream()
                .map(String::length) // Method Reference
                .collect(Collectors.toList());
    }

    // Optional Example
    public String getOptionalValue(Optional<String> optionalValue) {
        return optionalValue.orElse("Default Value");
    }

    // Functional Interface Example
    @FunctionalInterface
    public interface Greeting {
        String sayHello(String name);
    }

    public String greet(String name) {
        Greeting greeting = (n) -> "Hello, " + n; // Lambda Expression for Functional Interface
        return greeting.sayHello(name);
    }

    // Default Methods Example
    public interface Calculator {
        default int add(int a, int b) {
            return a + b; // Default Method
        }

        int subtract(int a, int b); // Abstract Method
    }

    public class SimpleCalculator implements Calculator {
        @Override
        public int subtract(int a, int b) {
            return a - b;
        }
    }

    public String calculate() {
        Calculator calculator = new SimpleCalculator();
        return "Add: " + calculator.add(5, 3) + ", Subtract: " + calculator.subtract(5, 3);
    }

    // Nashorn JavaScript Engine Example
    public String evaluateJavaScript(String script) {
        try {
            var engine = new javax.script.ScriptEngineManager().getEngineByName("nashorn");
            return engine.eval(script).toString();
        } catch (Exception e) {
            return "Error evaluating JavaScript: " + e.getMessage();
        }
    }

    // Stream API Example
    public List<String> processStream(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("a")) // Filter strings containing "a"
                .sorted() // Sort them
                .map(String::toUpperCase) // Convert to uppercase
                .collect(Collectors.toList());
    }

    // Date API Example
    public String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String parseDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

