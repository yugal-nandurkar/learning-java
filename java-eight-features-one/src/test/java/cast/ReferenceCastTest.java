package cast;

import microteam.feature.cast.Parent;
import microteam.feature.cast.Child;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReferenceCastTest {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("com.example");

        Parent parent = context.getBean(microteam.feature.cast.Parent.class);
        if (parent instanceof Child) {
            Child child = (Child) parent;
            System.out.println(child.childMethod());
        }

        context.close();
    }
}

