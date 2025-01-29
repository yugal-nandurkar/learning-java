package microteam.oops;


class Doggy {
    // Declaring and initializing the attributes
    String breed = "German Shepherd";
    int age = 2;
    String color = "Black";
}

public class AlteredDog {
    public static void main(String[] args) {
        // Creating an object of the class Dog
        Doggy obj = new Doggy();

        // Accessing class attributes & printing the values
        System.out.println("Before modifying:");
        System.out.println(obj.breed);
        System.out.println(obj.age);
        System.out.println(obj.color);

        // Modifying class attributes
        obj.breed = "Golden Retriever";
        obj.age = 3;
        obj.color = "Golden";

        // Printing
        System.out.println("\nAfter modifying:");
        System.out.println(obj.breed);
        System.out.println(obj.age);
        System.out.println(obj.color);
    }
}