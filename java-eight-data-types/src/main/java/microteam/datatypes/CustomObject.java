package microteam.datatypes;

public class CustomObject {
    private String name;
    private int value;

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomObject [name=" + name + ", value=" + value + "]";
    }
}

