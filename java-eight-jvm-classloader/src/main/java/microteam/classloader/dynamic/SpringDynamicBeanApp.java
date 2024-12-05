package microteam.classloader.dynamic;

import microteam.classloader.regular.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDynamicBeanApp implements CommandLineRunner {

    @Autowired
    private DynamicBeanLoader dynamicBeanLoader;

    @Autowired
    private MyBean myBean;

    public static void main(String[] args) {
        SpringApplication.run(SpringDynamicBeanApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dynamicBeanLoader.loadAndRegisterBean();

        // Use the dynamically registered bean
        myBean.sayHello();
    }
}

