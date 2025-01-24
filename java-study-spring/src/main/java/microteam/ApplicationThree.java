package microteam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationThree {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration-two.xml");
        MessagePrinter printer = (MessagePrinter) context.getBean("messagePrinter");
        printer.printMessage();
    }
}
