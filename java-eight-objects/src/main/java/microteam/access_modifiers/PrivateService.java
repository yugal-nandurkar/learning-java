package microteam.access_modifiers;

import org.springframework.stereotype.Service;

@Service
public class PrivateService {

    private String getGreeting(String name) {
        return "Hello, " + name + " from PrivateService!";
    }

    public String invokeGreeting(String name) {
        return getGreeting(name); // This is allowed because the method is called within the same class
    }
}

