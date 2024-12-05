package microteam.classloader.regular;

// Save this file separately as MyBean.java

import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private String message;

    // Constructor
    public MyBean(String message) {
        this.message = message;
    }

    public void sayHello() {
        System.out.println("Hello from MyBean!");
    }

    public String getMessage() {
        return message;
    }

    // Setter (optional)
    public void setMessage(String message) {
        this.message = message;
    }
}
