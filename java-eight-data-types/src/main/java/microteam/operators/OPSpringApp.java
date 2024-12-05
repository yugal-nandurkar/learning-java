package microteam.operators;

import microteam.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OPSpringApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OperatorService operatorService = context.getBean(OperatorService.class);

        int sum = operatorService.performArithmeticOperation(10, 5);
        boolean isGreater = operatorService.performRelationalOperation(10, 5);
        boolean logicalAnd = operatorService.performLogicalOperation(true, false);
        int bitwiseAnd = operatorService.performBitwiseOperation(6, 3); // 6 = 110, 3 = 011

        System.out.println("Sum: " + sum);
        System.out.println("Is Greater: " + isGreater);
        System.out.println("Logical AND: " + logicalAnd);
        System.out.println("Bitwise AND: " + bitwiseAnd);
    }
}
