package microteam.feature;

// Java Program Illustrating Lambda Expression with Instance Variables

// Interface
interface MyInterface {
    void myFunction();
}

// Main class
class InstanceVariable {
    // Custom initialization
    int data = 170;

    // Main driver method
    public static void main(String[] args) {
        // Creating object of this class
        InstanceVariable instva = new InstanceVariable();

        // Creating object of interface
        MyInterface intFace = () -> {
            System.out.println("Data: " + instva.data);
            instva.data += 500;
            System.out.println("Data after modification: " + instva.data);
        };

        // Using the lambda expression
        intFace.myFunction();

        // Modifying the instance variable
        instva.data += 200;
        System.out.println("Final Data: " + instva.data);
    }
}
