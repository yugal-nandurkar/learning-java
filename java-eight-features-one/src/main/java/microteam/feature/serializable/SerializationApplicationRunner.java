package microteam.feature.serializable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SerializationApplicationRunner implements CommandLineRunner {

    @Autowired
    private SerializationService serializationService;

    @Override
    public void run(String... args) {
        serializationService.demonstrateWriteReplace();
        serializationService.demonstrateStreamElements();
        serializationService.demonstrateReadResolve();
    }
}

