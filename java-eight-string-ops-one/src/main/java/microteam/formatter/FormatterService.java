package microteam.formatter;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Formatter;

@Service
public class FormatterService {

    /**
     * Formats a string with the provided format and arguments.
     *
     * @param format The format string.
     * @param args   The arguments referenced by the format specifiers in the format string.
     * @return The formatted string.
     */
    public String formatString(String format, Object... args) {
        try (Formatter formatter = new Formatter()) {
            return formatter.format(format, args).toString();
        }
    }

    /**
     * Formats a string to represent monetary values.
     *
     * @param amount The monetary amount.
     * @return The formatted monetary string.
     */
    public String formatCurrency(double amount) {
        String format = "$%,.2f"; // Example format for currency
        return formatString(format, amount);
    }

    /**
     * Formats a date or time based on provided format.
     *
     * @param format The date/time format string.
     * @param value  The value to be formatted.
     * @return The formatted date/time string.
     */
    public String formatDate(String format, Object value) {
        return formatString(format, value);
    }

}

