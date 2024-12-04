package microteam.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Package {
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

