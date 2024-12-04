package microteam.graalvm;

import org.graalvm.polyglot.*;

import java.util.List;

public class PostOffice {

    public static void main(String[] args) {
        // Create GraalVM JavaScript context
        try (Context context = Context.create()) {

            // Example 1: Pass Java object to JavaScript (Package example)
            Package package1 = new Package("John Doe", 3.5);

            // Convert the Java object into a GraalVM Value object
            Value packageValue = context.asValue(package1);

            // Put the package object into the JavaScript context
            context.getBindings("js").putMember("package", packageValue);

            // Accessing the package object's methods in JavaScript via GraalVM API
            String script1 = "package.getRecipient() + ' has a package weighing ' + package.getWeight() + 'kg';";
            String result1 = context.eval("js", script1).asString();
            System.out.println(result1); // Expected output: John Doe has a package weighing 3.5kg

            // Example 2: JavaScript function to calculate delivery time
            String script2 = "function calculateTime(distance) { return distance / 60; }";
            context.eval("js", script2);
            Object result2 = context.eval("js", "calculateTime(180)");
            System.out.println("Delivery time: " + result2 + " hours"); // Expected output: Delivery time: 3.0 hours

            // Example 3: Interacting with Java collections from JavaScript
            List<String> deliveries = List.of("Package 1", "Package 2", "Package 3");
            context.getBindings("js").putMember("deliveries", deliveries);
            String script3 = "deliveries.forEach(function(delivery) { print(delivery); });";
            context.eval("js", script3);
        }
    }

    // Package class used in the first example
    public static class Package {
        private String recipient;
        private double weight;

        public Package(String recipient, double weight) {
            this.recipient = recipient;
            this.weight = weight;
        }

        public String getRecipient() {
            return recipient;
        }

        public double getWeight() {
            return weight;
        }
    }
}
