package microteam;


// Importing the class
import java.util.Scanner;

public class NextLine {
    public static void main(String[] args) {
        // Creating an object of Scanner class
        Scanner sc = new Scanner(System.in);

        // Reading a String Input
        System.out.print("Input a string value: ");
        String str = sc.nextLine();

        System.out.print("The input is : " + str);
    }
}