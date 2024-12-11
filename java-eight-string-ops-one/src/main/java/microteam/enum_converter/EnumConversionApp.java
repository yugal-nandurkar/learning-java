package microteam.enum_converter;

import microteam.enum_converter.Role;
import microteam.enum_converter.EnumConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnumConversionApp implements CommandLineRunner {

    @Autowired
    private EnumConverterService enumConverterService;

    public static void main(String[] args) {
        SpringApplication.run(EnumConversionApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Example: Valid conversion
        Role role = enumConverterService.convertToEnum(Role.class, "admin", Role.GUEST);
        System.out.println("Converted Role: " + role); // Output: Converted Role: ADMIN

        // Example: Invalid conversion with default value (invalid_role is not valid)
        Role invalidRole = enumConverterService.convertToEnum(Role.class, "invalid_role", Role.GUEST);
        System.out.println("Invalid Role (fallback to default): " + invalidRole); // Output: Invalid Role (fallback to default): GUEST

        // Example: Conversion with empty string (should fall back to default)
        Role fallbackRole = enumConverterService.convertToEnum(Role.class, "", Role.GUEST);
        System.out.println("Fallback Role (empty input): " + fallbackRole); // Output: Fallback Role (empty input): GUEST
    }
}



