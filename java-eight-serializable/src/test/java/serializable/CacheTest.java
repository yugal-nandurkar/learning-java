package serializable;

import microteam.feature.serializable.CacheServiceUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTest {

    @Autowired
    private CacheServiceUsage cacheService;

    public static void main(String[] args) {
        CacheTest test = new CacheTest();

        // Invoke the service method and check the cache
        String result1 = test.cacheService.processData("testInput");
        String result2 = test.cacheService.processData("testInput");

        // Verify the cache was used
        System.out.println(result1.equals(result2)); // Should print "true"
    }
}

