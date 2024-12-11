import threading
import time

class StartupExample:

    def __init__(self, value, config, dependency):
        # 1. Validation of Inputs
        if value < 0 or value > 100:
            raise ValueError("Value must be between 0 and 100.")
        self.value = value

        # 2. Resource Allocation
        self.resource = self.Resource()

        # 3. Configuration Loading
        self.config = config if config is not None else self.load_default_config()

        # 4. Dependency Injection
        if dependency is None:
            raise ValueError("Dependency cannot be null.")
        self.dependency = dependency

        # 5. Default Value Assignment
        if not self.config:
            self.config = "DefaultConfig"

        # 6. Initialization of Collections
        self.items = []

        # 7. Calling Other Methods
        self.initialize_state()

        # 8. Logging and Monitoring
        print(f"StartupExample object created with value: {value}")

        # 9. Event Subscription (Simulated here with a listener setup)
        self.setup_event_listeners()

        # 10. Error Handling Setup (Simulating by setting up exception handler)
        threading.excepthook = lambda args: print(f"Unhandled exception: {args.exc_value}")

        # 11. Thread or Task Initialization
        self.start_background_task()

        # 12. Caching or Preloading Data
        self.preload_data()

    # Example of loading default configuration
    def load_default_config(self):
        return "DefaultConfigLoaded"

    # Example of state initialization
    def initialize_state(self):
        self.items.append("Initial Item")

    # Simulated event listener setup
    def setup_event_listeners(self):
        print("Event listeners set up.")

    # Simulated background task initialization
    def start_background_task(self):
        def background_task():
            while True:
                try:
                    time.sleep(5)
                    print("Background task running...")
                except KeyboardInterrupt:
                    break

        # Limit the number of threads to prevent "can't start new thread" errors
        if not hasattr(self, 'background_thread') or not self.background_thread.is_alive():
            self.background_thread = threading.Thread(target=background_task, daemon=True)
            self.background_thread.start()
        else:
            print("Background thread is already running.")

    # Example of data preloading
    def preload_data(self):
        self.items.extend(["Preloaded Item 1", "Preloaded Item 2"])
        print(f"Data preloaded: {self.items}")

    # Simulated resource class
    class Resource:
        def __init__(self):
            print("Resource allocated.")

    # Simulated dependency class
    class Dependency:
        def __init__(self):
            print("Dependency created.")

if __name__ == "__main__":
    # Creating the object and demonstrating the startup procedures
    dependency = StartupExample.Dependency()
    example = StartupExample(50, "CustomConfig", dependency)
