package microteam.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/random")
public class RandomStringController {

    private final RandomStringService randomStringService;

    @Autowired
    public RandomStringController(RandomStringService randomStringService) {
        this.randomStringService = randomStringService;
    }

    @GetMapping("/string")
    public ResponseEntity<?> generateRandomString(@RequestParam(name = "length") int length) {
        if (length <= 0) {
            return ResponseEntity.badRequest().body("Length must be greater than zero.");
        }
        try {
            String randomString = randomStringService.getRandomString(length);
            return ResponseEntity.ok(randomString);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An unexpected error occurred: " + e.getMessage());
        }
    }
}

