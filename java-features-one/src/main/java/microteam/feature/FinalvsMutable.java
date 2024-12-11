package microteam.feature;

// Java Program Illustrating Difference between
// Effectively final and Mutable Local Variables

// Importing required classes
// An example of capturing a local variable from the
// enclosing scope

// Interface
interface MyFunction {

    // Method inside the interface
    int func(int n);
}

// Main class
class FinalvsMutable {

    // Main driver method
    public static void main(String[] args)
    {

        // Custom local variable that can be captured
        int number = 10;

        MyFunction myLambda = (n) ->
        {

            // This use of number is OK It does not modify
            // num
            int value = number + n;

            // However, the following is illegal because it
            // attempts to modify the value of number

            // number++;
            return value;
        };

        //Using the Lambda expression
        System.out.println(myLambda.func(20));
        System.out.println("Final vs Mutable");
    }
}
