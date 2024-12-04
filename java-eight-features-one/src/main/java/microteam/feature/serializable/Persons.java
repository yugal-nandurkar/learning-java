package microteam.feature.serializable;

import java.io.Serializable;

// Regular serializable class
public class Persons implements Serializable {
    private static final long serialVersionUID = 1L; // SUID
    private String name;
    private int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

// Enum example
enum Role implements Serializable {
    ADMIN, USER, GUEST;
}

// Class containing an array
class Organization implements Serializable {
    private static final long serialVersionUID = 2L;
    private String orgName;
    private Person[] members;

    public Organization(String orgName, Person[] members) {
        this.orgName = orgName;
        this.members = members;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Organization{orgName='").append(orgName).append("', members=[");
        for (Person member : members) {
            builder.append(member).append(", ");
        }
        builder.append("]}");
        return builder.toString();
    }
}
