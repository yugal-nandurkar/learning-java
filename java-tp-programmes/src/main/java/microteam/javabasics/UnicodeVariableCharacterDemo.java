package microteam;


public class UnicodeVariableCharacterDemo {
    public static void main(String[] args) {
        // Storing Unicode characters using escape sequences
        char letterA = '\u0041';
        char letterSmallA = '\u0061';
        // Storing Unicode characters directly
        char letterB = 'B';

        // Manipulating the stored Unicode characters
        int difference = letterA - letterSmallA;
        char letterC = (char) (letterB + difference);
        char letterSmallC = (char) (letterC + 32);
        // Printing the manipulated Unicode characters
        System.out.println("Manipulated Unicode Characters:");
        System.out.println("Difference between A and a: " + difference);
        System.out.println("Calculated Letter C: " + letterC);
        System.out.println("Calculated Letter c: " + letterSmallC);
    }
}