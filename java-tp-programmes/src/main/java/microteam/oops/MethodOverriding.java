package microteam.oops;


class OverridingAnimal {
    public void move() {
        System.out.println("Animals can move");
    }
}

class OverridingDog extends OverridingAnimal {
    public void move() {
        System.out.println("Dogs can walk and run");
    }
}

public class MethodOverriding {

    public static void main(String args[]) {
        OverridingAnimal a = new OverridingAnimal();   // Animal reference and object
        OverridingAnimal b = new OverridingDog();   // Animal reference but Dog object

        a.move();   // runs the method in Animal class
        b.move();   // runs the method in Dog class
    }
}
