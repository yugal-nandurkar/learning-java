package microteam.access_modifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    private PublicService publicService;

    @Autowired
    protected ProtectedService protectedService;

    public void printGreetings(String name) {
        System.out.println(publicService.getGreeting(name));  // Accessible
        System.out.println(protectedService.getGreeting(name));  // Accessible in the same package
    }
}

