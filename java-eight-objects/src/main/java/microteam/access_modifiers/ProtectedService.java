package microteam.access_modifiers;

import org.springframework.stereotype.Service;

@Service
public class ProtectedService {

    public String getGreeting(String name) {
        return "Hello, " + name + " from ProtectedService!";
    }
}

