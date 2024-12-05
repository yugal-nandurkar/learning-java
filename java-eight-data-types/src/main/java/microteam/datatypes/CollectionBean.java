package microteam.datatypes;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionBean {
    private List<String> stringList;
    private Set<Integer> integerSet;
    private Map<String, String> stringMap;

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setIntegerSet(Set<Integer> integerSet) {
        this.integerSet = integerSet;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    @Override
    public String toString() {
        return "CollectionBean [stringList=" + stringList + ", integerSet=" + integerSet + ", stringMap=" + stringMap + "]";
    }
}

