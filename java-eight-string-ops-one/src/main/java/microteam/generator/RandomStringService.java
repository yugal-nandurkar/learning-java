package microteam.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomStringService {

    private final RandomStringGenerator randomStringGenerator;

    @Autowired
    public RandomStringService(RandomStringGenerator randomStringGenerator) {
        this.randomStringGenerator = randomStringGenerator;
    }

    public String getRandomString(int length) {
        return randomStringGenerator.generate(length);
    }
}

