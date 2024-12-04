package microteam.feature.serializable;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceUsage {

    @Cacheable(value = "myCache", keyGenerator = "serializableKeyGenerator")
    public String processData(String input) {
        return "Processed: " + input;
    }
}

