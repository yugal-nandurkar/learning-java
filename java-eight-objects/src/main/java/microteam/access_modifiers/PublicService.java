package microteam.access_modifiers;

import org.springframework.stereotype.Service;

@Service
public class PublicService {

    public String getGreeting(String name) {
        return "Hello, " + name + " from PublicService!";
    }
}

