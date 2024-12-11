package microteam.new_features.general;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.*;

@SpringBootApplication
public class FunctionalInterfacesApp {

    public static void main(String[] args) {
        SpringApplication.run(FunctionalInterfacesApp.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            // Function: Takes one argument and returns a result
            Function<String, Integer> stringLengthFunction = String::length;
            System.out.println("Length of 'Spring': " + stringLengthFunction.apply("Spring"));

            // Consumer: Takes one argument and returns no result
            Consumer<String> printConsumer = System.out::println;
            printConsumer.accept("Hello, Consumer!");

            // Supplier: Takes no arguments and returns a result
            Supplier<Double> randomSupplier = Math::random;
            System.out.println("Random Number: " + randomSupplier.get());

            // Predicate: Takes one argument and returns a boolean
            Predicate<Integer> isEvenPredicate = num -> num % 2 == 0;
            System.out.println("Is 4 even? " + isEvenPredicate.test(4));

            // BiFunction: Takes two arguments and returns a result
            BiFunction<Integer, Integer, Integer> addFunction = Integer::sum;
            System.out.println("Sum of 5 and 3: " + addFunction.apply(5, 3));

            // BinaryOperator: Like BiFunction but with the same types for arguments and result
            BinaryOperator<Integer> multiplyOperator = (a, b) -> a * b;
            System.out.println("Product of 6 and 4: " + multiplyOperator.apply(6, 4));

            // UnaryOperator: Like Function but with the same type for input and output
            UnaryOperator<String> toUpperCaseOperator = String::toUpperCase;
            System.out.println("Uppercase 'spring': " + toUpperCaseOperator.apply("spring"));
        };
    }
}

