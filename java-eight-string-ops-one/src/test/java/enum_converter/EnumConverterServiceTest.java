package enum_converter;

import microteam.enum_converter.EnumConverterService;
import microteam.enum_converter.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumConverterServiceTest {

    private final EnumConverterService enumConverterService = new EnumConverterService();

    @Test
    void testValidConversion() {
        Role role = enumConverterService.convertToEnum(Role.class, "USER", Role.GUEST);
        assertEquals(Role.USER, role);
    }

    @Test
    void testInvalidConversion() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            enumConverterService.convertToEnum(Role.class, "INVALID", Role.GUEST);
        });
        assertTrue(exception.getMessage().contains("Invalid value"));
    }

    @Test
    void testNullValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            enumConverterService.convertToEnum(Role.class, null, Role.GUEST);
        });
        assertEquals("Value cannot be null or empty.", exception.getMessage());
    }
}

