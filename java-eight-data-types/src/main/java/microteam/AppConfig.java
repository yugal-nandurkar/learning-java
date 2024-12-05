package microteam;

import microteam.datatypes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@Configuration
@ComponentScan(basePackages = "microteam")
public class AppConfig {

    @Bean
    public PrimitiveBean primitiveBean() {
        PrimitiveBean bean = new PrimitiveBean();
        bean.setIntegerValue(42);
        bean.setDoubleValue(3.14);
        bean.setBooleanValue(true);
        return bean;
    }

    @Bean
    public CollectionBean collectionBean() {
        CollectionBean bean = new CollectionBean();
        bean.setStringList(Arrays.asList("Spring", "Java", "Hibernate"));
        bean.setIntegerSet(new HashSet<>(Arrays.asList(10, 20, 30)));
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        bean.setStringMap(map);
        return bean;
    }

    @Bean
    public CustomObject customObject() {
        CustomObject object = new CustomObject();
        object.setName("MyCustomObject");
        object.setValue(100);
        return object;
    }

    @Bean
    public ObjectBean objectBean(CustomObject customObject) {
        ObjectBean bean = new ObjectBean();
        bean.setCustomObject(customObject);
        return bean;
    }

    private CustomObject createCustomObject(String name, int value) {
        CustomObject customObject = new CustomObject();
        customObject.setName(name);
        customObject.setValue(value);
        return customObject;
    }

    @Bean
    public ArrayBean arrayBean() {
        ArrayBean arrayBean = new ArrayBean();

        // Set string array
        arrayBean.setStringArray(new String[]{"Spring", "Java", "Hibernate"});

        // Set int array
        arrayBean.setIntArray(new int[]{1, 2, 3});

        // Set object array
        arrayBean.setObjectArray(new CustomObject[]{
                createCustomObject("Object1", 10),
                createCustomObject("Object2", 20)
        });

        return arrayBean;
    }
}

