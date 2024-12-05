package microteam.datatypes;

import microteam.AppConfig;
import microteam.operators.OperatorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DTSpringApp {
    public static void main(String[] args) {
        // Load the Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the beans and print them
        PrimitiveBean primitiveBean = context.getBean(PrimitiveBean.class);
        System.out.println(primitiveBean);

        CollectionBean collectionBean = context.getBean(CollectionBean.class);
        System.out.println(collectionBean);

        ObjectBean objectBean = context.getBean(ObjectBean.class);
        System.out.println(objectBean);

        // Using Annotation-based configuration
        ArrayBean arrayBeanAnnotation = context.getBean(ArrayBean.class);
        System.out.println("Annotation Config: " + arrayBeanAnnotation);

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();

        // Using XML-based configuration
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArrayBean arrayBeanXml = xmlContext.getBean("arrayBean", ArrayBean.class);
        System.out.println("XML Config: " + arrayBeanXml);

    }
}
