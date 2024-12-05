package lambda;

// Java code to illustrate lambda expression
// with single parameter

// functional interface
// with one parameter of Integer type
interface TestThree {
    // The void type and the Integer type
    // is automatically inferred from here
    // and assigned to the lambda expression
    void print(Integer p);
}

class GfGThree {
    // takes lambda expression and a variable of
    // Integer type as arguments
    static void fun(TestThree t, Integer p)
    {
        // calls the print function
        t.print(p);
    }
    public static void main(String[] args)
    {
        // lambda expression is passed
        // with a single parameter
        // lambda expression is mapped to the
        // single argument abstract function in the
        // functional interface Test2
        fun(p -> System.out.println(p), 10);
    }
}