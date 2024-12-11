package microteam.records;

// Using the Record
public class RecordRunner {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);

        // Accessor methods
        System.out.println(person.name()); // Output: Alice
        System.out.println(person.age());  // Output: 30

        // Auto-generated toString(), equals(), hashCode()
        System.out.println(person);        // Output: Person[name=Alice, age=30]
    }
}