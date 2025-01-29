package microteam;


class Vehicle {}

public class InstanceOfCar extends Vehicle {

    public static void main(String args[]) {

        Vehicle a = new InstanceOfCar();
        boolean result =  a instanceof InstanceOfCar;
        System.out.println( result );
    }
}
