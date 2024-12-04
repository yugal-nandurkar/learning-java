package microteam.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.List;

public class PostOffice {

    public static void main(String[] args) throws ScriptException {
        // Create Nashorn engine
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        // Example 1: Pass Java object to JavaScript (Package example)
        Package package1 = new Package("John Doe", 3.5);
        engine.put("package", package1);
        String script1 = "package.getRecipient() + ' has a package weighing ' + package.getWeight() + 'kg';";
        Object result1 = engine.eval(script1);
        System.out.println(result1); // Output: John Doe has a package weighing 3.5kg

        // Example 2: JavaScript function to calculate delivery time
        String script2 = "function calculateTime(distance) { return distance / 60; }";
        engine.eval(script2);
        Object result2 = engine.eval("calculateTime(180)");
        System.out.println("Delivery time: " + result2 + " hours"); // Output: Delivery time: 3.0 hours

        // Example 3: Interacting with Java collections from JavaScript
        List<String> deliveries = Arrays.asList("Package 1", "Package 2", "Package 3");
        engine.put("deliveries", deliveries);
        String script3 = "deliveries.forEach(function(delivery) { print(delivery); });";
        engine.eval(script3);
    }
}