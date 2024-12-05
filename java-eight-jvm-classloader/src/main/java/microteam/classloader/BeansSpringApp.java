package microteam.classloader;

import microteam.classloader.regular.LifecycleBean;
import microteam.classloader.regular.MyService;
import microteam.classloader.regular.PrototypeBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansSpringApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Using MyService
        MyService myService = context.getBean("myService", MyService.class);
        myService.performTask();

        // Using LifecycleBean
        LifecycleBean lifecycleBean = context.getBean("lifecycleBean", LifecycleBean.class);
        // Lifecycle callbacks will execute automatically

        // Using PrototypeBean
        PrototypeBean prototypeBean1 = context.getBean("prototypeBean", PrototypeBean.class);
        prototypeBean1.execute();

        PrototypeBean prototypeBean2 = context.getBean("prototypeBean", PrototypeBean.class);
        prototypeBean2.execute();

        // Closing the context to invoke destroy-method for singleton beans
        ((ClassPathXmlApplicationContext) context).close();
    }
}
