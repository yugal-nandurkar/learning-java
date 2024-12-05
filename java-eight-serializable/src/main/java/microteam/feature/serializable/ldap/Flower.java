package microteam.feature.serializable.ldap;

import java.io.Serializable;

public class Flower implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String color;

    public Flower(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return color + " " + name;
    }

    // Getters and setters omitted for brevity
}

