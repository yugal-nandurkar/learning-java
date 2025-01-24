package microteam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration.xml");
        GreetingService service = (GreetingService) context.getBean("greetingService");
        System.out.println(service.greet("World"));
    }
}
