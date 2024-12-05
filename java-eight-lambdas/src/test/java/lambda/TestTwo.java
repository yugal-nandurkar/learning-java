package lambda;

// Java code to illustrate lambda expression
// without parameters

// functional interface
// without parameters
interface TestTwo {
    void print();
}

class GfGTwo {
    // functional interface parameter is passed
    static void fun(TestTwo t) { t.print(); }
    public static void main(String[] args)
    {
        // lambda expression is passed
        // without parameter to functional interface t
        fun(() -> System.out.println("Hello"));
    }
}
