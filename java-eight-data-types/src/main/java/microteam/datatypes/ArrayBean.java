package microteam.datatypes;

import java.util.Arrays;

public class ArrayBean {
    private String[] stringArray;
    private int[] intArray;
    private CustomObject[] objectArray;

    public void setStringArray(String[] stringArray) {
        this.stringArray = stringArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    public void setObjectArray(CustomObject[] objectArray) {
        this.objectArray = objectArray;
    }

    @Override
    public String toString() {
        return "ArrayBean{" +
                "stringArray=" + Arrays.toString(stringArray) +
                ", intArray=" + Arrays.toString(intArray) +
                ", objectArray=" + Arrays.toString(objectArray) +
                '}';
    }
}

