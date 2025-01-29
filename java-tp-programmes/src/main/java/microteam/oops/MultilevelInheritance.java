package microteam.oops;


class OneMLI {
    public void printOne() {
        System.out.println("printOne() method of One class.");
    }
}

class Two extends OneMLI {
    public void printTwo() {
        System.out.println("printTwo() method of Two class.");
    }
}

public class MultilevelInheritance extends Two {
    public static void main(String args[]) {
        // Creating object of the derived class (Main)
        MultilevelInheritance obj = new MultilevelInheritance();

        // Calling methods
        obj.printOne();
        obj.printTwo();
    }
}
