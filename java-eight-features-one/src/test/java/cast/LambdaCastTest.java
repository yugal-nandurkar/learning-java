package cast;

import microteam.feature.cast.LambdaCastConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Function;

public class LambdaCastTest {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(LambdaCastConfig.class);

        Function<String, String> function = context.getBean(Function.class);
        System.out.println(function.apply("Hello"));

        context.close();
    }
}

