package microteam.feature.serializable;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private transient int age; // Will not be serialized

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Define writeReplace to replace this object during serialization
    private Object writeReplace() throws ObjectStreamException {
        return new PersonReplacement(name); // Replace with another object
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

// Replacement class
class PersonReplacement implements Serializable {
    private String name;

    public PersonReplacement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonReplacement{name='" + name + "'}";
    }
}

