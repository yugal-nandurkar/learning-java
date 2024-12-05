package microteam.lambda.safety;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class UnsafeTaskService {

    public void executeUnsafeTasks() {
        int[] total = new int[1]; // Mutable object

        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            Runnable task = () -> {
                total[0]++;
                System.out.println("Total incremented to: " + total[0]);
            };

            for (int i = 0; i < 5; i++) {
                executor.submit(task);
            }
        } finally {
            executor.shutdown();
        }

        System.out.println("All unsafe tasks submitted.");
    }
}
