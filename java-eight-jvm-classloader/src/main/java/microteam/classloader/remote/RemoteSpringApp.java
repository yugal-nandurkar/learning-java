package microteam.classloader.remote;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RemoteSpringApp  {

    public static void main(String[] args) {
        SpringApplication.run(RemoteSpringApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(AppletManager appletManager) {
        return (args) -> {
            System.out.println("SpringApp started. Try using the REST endpoints.");

            // Example usage of the AppletManager (uncomment if testing programmatically)
            // String appletName = "com.example.MyApplet";
            // Object applet = appletManager.loadApplet(appletName);
            // System.out.println("Loaded applet: " + applet);
        };
    }
}
