package microteam.datatypes;

public class ObjectBean {
    private CustomObject customObject;

    public void setCustomObject(CustomObject customObject) {
        this.customObject = customObject;
    }

    @Override
    public String toString() {
        return "ObjectBean [customObject=" + customObject + "]";
    }
}

