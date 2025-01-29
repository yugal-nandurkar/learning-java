package microteam.oops;

interface Vegetarian{}
class PolyNoAnimal{}
public class DeerPolymorphism extends PolyNoAnimal implements Vegetarian{
    public static void main(String[] args) {
        DeerPolymorphism d = new DeerPolymorphism();
        PolyNoAnimal a = d;
        Vegetarian v = d;
        Object o = d;

        System.out.println(d instanceof DeerPolymorphism);
        System.out.println(a instanceof DeerPolymorphism);
        System.out.println(v instanceof DeerPolymorphism);
        System.out.println(o instanceof DeerPolymorphism);
    }
}
