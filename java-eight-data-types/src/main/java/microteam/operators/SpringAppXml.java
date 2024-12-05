package microteam.operators;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppXml {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        int arithmeticResult = (Integer) context.getBean("arithmeticResult");
        boolean relationalResult = (Boolean) context.getBean("relationalResult");
        boolean logicalResult = (Boolean) context.getBean("logicalResult");
        int bitwiseResult = (Integer) context.getBean("bitwiseResult");

        System.out.println("Arithmetic Result: " + arithmeticResult);
        System.out.println("Relational Result: " + relationalResult);
        System.out.println("Logical Result: " + logicalResult);
        System.out.println("Bitwise Result: " + bitwiseResult);
    }
}
