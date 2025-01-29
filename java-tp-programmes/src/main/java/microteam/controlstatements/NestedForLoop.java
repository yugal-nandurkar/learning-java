package microteam.controlstatements;

public class NestedForLoop {
    public static void main(String[] args) {
        // Implementing nested for loop
        // Initializing loop counters
        int num = 1;
        int i = 1;

        // outer for loop
        for (num = 1; num <= 10; num++) {
            //inner for loop
            System.out.print("Table of " + num + " is : ");
            for (i = 1; i <= 10; i++) {
                // printing table
                System.out.print(num * i + " ");
            }
            // printing a new line
            System.out.println();
        }
    }
}