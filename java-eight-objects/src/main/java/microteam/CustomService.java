package microteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

    private final CustomObject customObject;

    @Autowired
    public CustomService(CustomObject customObject) {
        this.customObject = customObject;
    }

    public String getCustomValue() {
        return customObject.getValue();
    }
}

