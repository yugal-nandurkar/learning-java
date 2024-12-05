package microteam.classloader.regular;

import org.springframework.util.ClassUtils;

public class SpringClassUtilsExample {

    public static void main(String[] args) {
        // Load a class dynamically using Spring's ClassUtils
        Class<?> clazz = ClassUtils.resolveClassName("microteam.classloader.dynamic.MyDynamicClass", ClassUtils.getDefaultClassLoader());
        System.out.println("Loaded class: " + clazz.getName());
    }
}
