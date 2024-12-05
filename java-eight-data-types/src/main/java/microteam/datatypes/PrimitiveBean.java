package microteam.datatypes;

public class PrimitiveBean {
    private int integerValue;
    private double doubleValue;
    private boolean booleanValue;

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    @Override
    public String toString() {
        return "PrimitiveBean [integerValue=" + integerValue + ", doubleValue=" + doubleValue + ", booleanValue=" + booleanValue + "]";
    }
}
