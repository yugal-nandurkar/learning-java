package microteam.enum_converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/convert")
public class EnumConverterController {

    @Autowired
    private EnumConverterService enumConverterService;

    @GetMapping("/to-enum")
    public Role convertToEnum(@RequestParam String value) {
        return enumConverterService.convertToEnum(Role.class, value, Role.GUEST);
    }
}

