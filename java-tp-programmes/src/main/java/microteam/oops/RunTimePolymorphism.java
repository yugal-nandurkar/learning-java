package microteam.oops;

// Java Example: Run Time Polymorphism
class RTPVehicle {
    public void displayInfo() {
        System.out.println("Some vehicles are there.");
    }
}

class Car extends RTPVehicle {
    // Method overriding
    @Override
    public void displayInfo() {
        System.out.println("I have a Car.");
    }
}

class Bike extends RTPVehicle {
    // Method overriding
    @Override
    public void displayInfo() {
        System.out.println("I have a Bike.");
    }
}

public class RunTimePolymorphism {
    public static void main(String[] args) {
        RTPVehicle v1 = new Car(); // Upcasting
        RTPVehicle v2 = new Bike(); // Upcasting

        // Calling the overridden displayInfo() method of Car class
        v1.displayInfo();

        // Calling the overridden displayInfo() method of Bike class
        v2.displayInfo();
    }
}