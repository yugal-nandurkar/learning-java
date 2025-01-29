package microteam;


// Importing the class
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        // Creating an object of Scanner class
        Scanner sc = new Scanner(System.in);

        // Reading two Integer numbers
        // using nextInt() method
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();

        // Calculating the sum
        int sum = num1 + num2;

        // Printing the su
        System.out.println("The sum of the two numbers is: " + sum);
    }
}