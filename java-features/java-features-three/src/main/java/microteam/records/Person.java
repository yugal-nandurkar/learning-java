package microteam.records;

// Define a Record
public record Person(String name, int age) {
    // Optional: Compact constructor for validation
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
