package microteam.feature.cast;

import org.springframework.stereotype.Component;

@Component
public class Parent {
    public String parentMethod() {
        return "Parent method invoked!";
    }
}
