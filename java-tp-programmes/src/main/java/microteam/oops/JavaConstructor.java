package microteam.oops;


public class JavaConstructor {
    // Creating a constructor
    JavaConstructor() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        System.out.println("The main() method.");

        // Creating a class's object
        // that will invoke the constructor
        JavaConstructor obj_x = new JavaConstructor();
    }
}
