package microteam.classloader.regular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    @Autowired
    private ResourceLoader resourceLoader;

    public void loadResource(String resourcePath) {
        Resource resource = resourceLoader.getResource(resourcePath);
        System.out.println("Resource exists: " + resource.exists());
    }

    public void setMyBean(MyBean myBean) {

    }
}
