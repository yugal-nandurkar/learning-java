package microteam.general;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValueStringService {

    @Value("${greeting.message}")
    private String greetingMessage;

    public String getGreetingMessage() {
        return greetingMessage;
    }
}

