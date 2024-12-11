package microteam.formatter.advanced;

import org.springframework.stereotype.Service;

import java.util.Formatter;

@Service
public class AdvancedFormatterService {

    /**
     * Formats a string using argument index, precision, and flags.
     *
     * @param format The format string.
     * @param args   The arguments referenced by the format specifiers.
     * @return The formatted string.
     */
    public String advancedFormat(String format, Object... args) {
        try (Formatter formatter = new Formatter()) {
            return formatter.format(format, args).toString();
        }
    }

    /**
     * Appends a formatted string to an Appendable.
     *
     * @param appendable The appendable object (e.g., StringBuilder).
     * @param format     The format string.
     * @param args       The arguments for the format string.
     * @return The Appendable with the appended formatted string.
     */
    public Appendable formatToAppendable(Appendable appendable, String format, Object... args) {
        try (Formatter formatter = new Formatter(appendable)) {
            formatter.format(format, args);
        } catch (Exception e) {
            throw new RuntimeException("Error formatting to appendable", e);
        }
        return appendable;
    }

    /**
     * Demonstrates using flags, precision, and argument index.
     *
     * @return A string demonstrating the features.
     */
    public String demonstrateAdvancedFeatures() {
        StringBuilder result = new StringBuilder();
        try (Formatter formatter = new Formatter(result)) {
            // Example 1: Argument index
            formatter.format("Argument Index: %2$s is after %1$s.%n", "first", "second");

            // Example 2: Flags (e.g., left-align, padding)
            formatter.format("Flags: |%-10s|%10s|%n", "left", "right");

            // Example 3: Precision (e.g., decimal places for floating points)
            formatter.format("Precision: %.2f%n", 123.456);

            // Example 4: Combining flags and precision
            formatter.format("Combined: |%+08.2f|%n", 42.7);
        }
        return result.toString();
    }
}
