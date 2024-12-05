package microteam.classloader.regular;

public class MyService {
    private MyBean myBean;

    // Setter for dependency injection
    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }

    // A simple method to demonstrate functionality
    public void performTask() {
        System.out.println("Task performed with: " + myBean.getMessage());
    }
}
