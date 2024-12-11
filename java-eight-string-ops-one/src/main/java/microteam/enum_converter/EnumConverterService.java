package microteam.enum_converter;

import org.springframework.stereotype.Service;

@Service
public class EnumConverterService {

    /**
     * Converts a String to the specified Enum type, with an option for a default value if invalid input is given.
     *
     * @param <T>          The type of Enum.
     * @param enumType     The Enum class type.
     * @param value        The String value to be converted.
     * @param defaultValue The default Enum value to return if the input is invalid.
     * @return The corresponding Enum value or the default value if the input is invalid.
     */
    public <T extends Enum<T>> T convertToEnum(Class<T> enumType, String value, T defaultValue) {
        if (value == null || value.isEmpty()) {
            return defaultValue; // Return default value for null or empty input
        }

        for (T enumConstant : enumType.getEnumConstants()) {
            if (enumConstant.name().equalsIgnoreCase(value)) {
                return enumConstant;
            }
        }

        return defaultValue; // Return default value if no match is found
    }
}

