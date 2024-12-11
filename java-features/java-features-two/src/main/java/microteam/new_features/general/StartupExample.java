package microteam.new_features.general;

import java.util.*;

public class StartupExample {

    private int value; // Instance variable with validation
    private String config;
    private List<String> items; // Collection initialization
    private Resource resource; // Example resource allocation
    private Dependency dependency; // Dependency injection

    public StartupExample(int value, String config, Dependency dependency) {
        // 1. Validation of Inputs
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Value must be between 0 and 100.");
        }
        this.value = value;

        // 2. Resource Allocation
        this.resource = new Resource();

        // 3. Configuration Loading
        this.config = (config != null) ? config : loadDefaultConfig();

        // 4. Dependency Injection
        if (dependency == null) {
            throw new IllegalArgumentException("Dependency cannot be null.");
        }
        this.dependency = dependency;

        // 5. Default Value Assignment
        if (this.config.isEmpty()) {
            this.config = "DefaultConfig";
        }

        // 6. Initialization of Collections
        this.items = new ArrayList<>();

        // 7. Calling Other Methods
        initializeState();

        // 8. Logging and Monitoring
        System.out.println("StartupExample object created with value: " + value);

        // 9. Event Subscription (Simulated here with a listener setup)
        setupEventListeners();

        // 10. Error Handling Setup (Simulating by setting up exception handler)
        Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
            System.err.println("Unhandled exception: " + ex.getMessage());
        });

        // 11. Thread or Task Initialization
        startBackgroundTask();

        // 12. Caching or Preloading Data
        preloadData();
    }

    // Example of loading default configuration
    private String loadDefaultConfig() {
        return "DefaultConfigLoaded";
    }

    // Example of state initialization
    private void initializeState() {
        items.add("Initial Item");
    }

    // Simulated event listener setup
    private void setupEventListeners() {
        System.out.println("Event listeners set up.");
    }

    // Simulated background task initialization
    private void startBackgroundTask() {
        Thread backgroundThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Background task running...");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

    // Example of data preloading
    private void preloadData() {
        items.addAll(Arrays.asList("Preloaded Item 1", "Preloaded Item 2"));
        System.out.println("Data preloaded: " + items);
    }

    // Simulated resource class
    static class Resource {
        public Resource() {
            System.out.println("Resource allocated.");
        }
    }

    // Simulated dependency class
    static class Dependency {
        public Dependency() {
            System.out.println("Dependency created.");
        }
    }

    public static void main(String[] args) {
        // Creating the object and demonstrating the startup procedures
        Dependency dependency = new Dependency();
        StartupExample example = new StartupExample(50, "CustomConfig", dependency);
    }
}

