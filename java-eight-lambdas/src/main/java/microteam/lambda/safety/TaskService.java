package microteam.lambda.safety;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class TaskService {

    public void executeTasks() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Protecting object variables by using immutable collections
        List<Integer> immutableNumbers = Collections.unmodifiableList(new ArrayList<>(numbers));

        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            immutableNumbers.forEach(number -> executor.submit(() -> {
                // Safely using immutable object
                System.out.println("Processing number: " + number);
            }));
        } finally {
            executor.shutdown();
        }

        System.out.println("All tasks submitted.");
    }
}

