package microteam.classloader.regular;

public class LifecycleBean {

    public void init() {
        System.out.println("LifecycleBean: Initialization logic executed.");
    }

    public void destroy() {
        System.out.println("LifecycleBean: Cleanup logic executed.");
    }
}
