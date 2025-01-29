package microteam;


import java.util.Scanner;

public class NextFloat {
    public static void main(String[] args) {
        // Creating an object of Scanner class
        Scanner sc = new Scanner(System.in);

        // Reading a Float Input
        System.out.print("Input a float value: ");
        float float_num = sc.nextFloat();

        System.out.print("The input is : " + float_num);
    }
}
