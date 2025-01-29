package microteam.oops;


public class ParameterizedConstructor {
    int num1;
    int num2;

    // Creating parameterized constructor
    ParameterizedConstructor(int a, int b) {
        num1 = a;
        num2 = b;
    }

    public static void main(String[] args) {
        // Creating two objects by passing the values
        // to initialize the attributes.
        // parameterized constructor will invoke
        ParameterizedConstructor obj_x = new ParameterizedConstructor(10, 20);
        ParameterizedConstructor obj_y = new ParameterizedConstructor(100, 200);

        // Printing the objects values
        System.out.println("obj_x");
        System.out.println("num1 : " + obj_x.num1);
        System.out.println("num2 : " + obj_x.num2);

        System.out.println("obj_y");
        System.out.println("num1 : " + obj_y.num1);
        System.out.println("num2 : " + obj_y.num2);
    }
}
