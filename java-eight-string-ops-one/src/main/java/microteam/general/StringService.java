package microteam.general;

import org.springframework.stereotype.Service;

@Service
public class StringService {

    private final String greeting;

    public StringService() {
        this.greeting = "Hello from StringService!";
    }

    public String getGreeting() {
        return greeting;
    }
}
