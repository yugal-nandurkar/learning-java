package microteam.access_modifiers;

import org.springframework.stereotype.Service;

@Service
public class DefaultService {

    public String getGreeting(String name) {
        return "Hello, " + name + " from DefaultService!";
    }
}
