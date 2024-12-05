package microteam.lambda.safety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SafetyApplicationRunner  implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UnsafeTaskService unsafeTaskService;

    @Override
    public void run(String... args) {
        System.out.println("Running safe task execution:");
        taskService.executeTasks();

        System.out.println("\nRunning unsafe task execution:");
        unsafeTaskService.executeUnsafeTasks();
    }
}

