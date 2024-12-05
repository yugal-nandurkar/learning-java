package microteam.feature.cast;

import java.io.Serializable;

interface MyFunctionalInterface extends Serializable {
    void execute();
}

public class IntersectionTypeExample {

    public static void main(String[] args) {
        // Casting a lambda to an intersection type
        MyFunctionalInterface action = (MyFunctionalInterface & Serializable) () -> {
            System.out.println("Lambda with intersection type executed!");
        };

        action.execute();
    }
}
