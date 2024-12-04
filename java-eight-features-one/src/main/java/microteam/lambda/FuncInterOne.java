package microteam.lambda;

@FunctionalInterface
interface FuncInterOne {
    int operation(int a, int b);
}

 class Test {

    public static void main(String[] args) {
        // Using lambda expressions to define the operations
        FuncInterOne add = (a, b) -> a + b;
        FuncInterOne multiply = (a, b) -> a * b;

        // Using the operations
        System.out.println(add.operation(6, 3));  // Output: 9
        System.out.println(multiply.operation(4, 5));  // Output: 20
    }
}