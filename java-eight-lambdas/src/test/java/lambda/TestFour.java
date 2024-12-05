package lambda;

// Java code to illustrate lambda expression
// with multi parameters

// functional interface Test3
// with 2 parameter of Integer type
interface TestFour {
    // The void type and the Integer type
    // is automatically inferred from here
    // and assigned to the lambda expression
    void print(Integer p1, Integer p2);
}

class GfGFour {
    // takes parameter of Test3 type followed
    // by 2 integer parameters p1 and p2
    static void fun(TestFour t, Integer p1, Integer p2)
    {
        // calls the print function
        t.print(p1, p2);
    }
    public static void main(String[] args)
    {
        // lambda expression is passed
        // with two parameters
        // lambda expression is mapped to the
        // double argument abstract function in the
        // functional interface Test3
        fun((p1, p2)
                        -> System.out.println(p1 + " " + p2),
                10, 20);
    }
}