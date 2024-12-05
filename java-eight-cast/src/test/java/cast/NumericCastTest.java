package cast;

import microteam.feature.cast.NumericCastConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NumericCastTest {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(NumericCastConfig.class);

        Double doubleValue = context.getBean("castedDoubleValue", Double.class);
        System.out.println("Double Value: " + doubleValue);

        int intValue = context.getBean("castedIntValue", Integer.class);
        System.out.println("Int Value: " + intValue);

        context.close();
    }
}

