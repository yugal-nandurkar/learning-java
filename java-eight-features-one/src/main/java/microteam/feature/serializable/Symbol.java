package microteam.feature.serializable;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Symbol implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Map<String, Symbol> SYMBOL_CACHE = new HashMap<>();

    private final String name;

    private Symbol(String name) {
        this.name = name;
    }

    // Factory method to ensure uniqueness
    public static Symbol getInstance(String name) {
        return SYMBOL_CACHE.computeIfAbsent(name, Symbol::new);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Symbol{name='" + name + "'}";
    }

    // Ensure uniqueness during deserialization
    private Object readResolve() throws ObjectStreamException {
        return getInstance(name);
    }
}

