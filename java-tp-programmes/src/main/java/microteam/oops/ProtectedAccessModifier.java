package microteam.oops;


// Class One
class One {
    protected void printOne() {
        System.out.println("printOne method of One class.");
    }
}

// Inheriting class One on Main
public class ProtectedAccessModifier extends One {
    public static void main(String[] args) {
        // Creating an object of Main class
        ProtectedAccessModifier obj = new ProtectedAccessModifier();

        // Calling printOne() method of class One
        // through the object of Main class
        obj.printOne();
    }
}
