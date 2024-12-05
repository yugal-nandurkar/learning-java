package microteam.feature.cast;

import org.springframework.stereotype.Component;

@Component
public class Child extends Parent {
    public String childMethod() {
        return "Child method invoked!";
    }
}
