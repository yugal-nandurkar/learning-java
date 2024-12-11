package microteam.apache;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomStringService {

    // Generate a random alphanumeric string of a given length
    public String generateRandomAlphanumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    // Generate a random alphabetic string of a given length
    public String generateRandomAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    // Generate a random numeric string of a given length
    public String generateRandomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    // Generate a random string with specified characters and length
    public String generateRandomCustom(int length, String characters) {
        return RandomStringUtils.random(length, characters);
    }
}
