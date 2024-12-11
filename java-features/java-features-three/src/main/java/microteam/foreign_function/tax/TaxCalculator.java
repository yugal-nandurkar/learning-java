package microteam.foreign_function.tax;

public class TaxCalculator {

    // Load the shared library (DLL or .so file)
    static {
        System.loadLibrary("calculate_tax");  // Ensure this matches the DLL name (no extension)
    }

    // Declare the native method
    public native double calculateTax(double income);

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();

        // Call the native method and print the result
        double income = 50000.0;
        double tax = calculator.calculateTax(income);
        System.out.printf("The tax for an income of %.2f is: %.2f%n", income, tax);
    }
}
