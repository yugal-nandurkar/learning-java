package microteam.classloader.regular;

public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("PrototypeBean: New instance created!");
    }

    public void execute() {
        System.out.println("PrototypeBean: Method executed.");
    }
}
