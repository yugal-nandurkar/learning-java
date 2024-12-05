package microteam.classloader.regular;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassLoaderExample {

    public static void main(String[] args) {
        // Load Spring context using the application class loader
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        MyBean myBean = context.getBean(MyBean.class);
        System.out.println("Bean loaded: " + myBean);
        context.close();
    }
}
