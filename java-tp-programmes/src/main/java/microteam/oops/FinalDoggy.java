package microteam.oops;


class ReadOnlyDog {
    final String name = "Tommy";
}

public class FinalDoggy {
    public static void main(String[] args) {
        ReadOnlyDog dog = new ReadOnlyDog();
        // dog.name = "Tommy";  // Error while modifying name: Cannot assign a value to final variable 'name'
        System.out.println(dog.name);
    }
}