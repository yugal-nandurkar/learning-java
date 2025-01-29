package microteam.oops;

class Logger {
    private String format;

    String getFormat() {
        return this.format;
    }

    void setFormat(String format) {
        this.format = format;
    }
}

public class PrivateAccessModifier {
    public static void main(String[] args) {
        // Creating an object
        Logger log = new Logger();
        // Setting the value
        log.setFormat("Text");
        // Getting the value
        System.out.println(log.getFormat());

    }
}