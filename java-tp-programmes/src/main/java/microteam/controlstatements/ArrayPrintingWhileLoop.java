package microteam.controlstatements;


public class ArrayPrintingWhileLoop {

    public static void main(String args[]) {
        int [] numbers = {10, 20, 30, 40, 50};
        int index = 0;

        while( index < 5 ) {
            System.out.print("value of item : " + numbers[index] );
            index++;
            System.out.print("\n");
        }
    }
}
