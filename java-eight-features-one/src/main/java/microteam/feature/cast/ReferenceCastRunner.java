package microteam.feature.cast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReferenceCastRunner implements CommandLineRunner {

    @Autowired
    private Parent parentBean;

    @Override
    public void run(String... args) {
        // Reference cast: Parent to Child
        if (parentBean instanceof Child) { // Check before casting
            Child child = (Child) parentBean; // Cast at runtime
            System.out.println(child.childMethod());
        } else {
            System.out.println("The bean is not an instance of Child.");
        }
    }
}
