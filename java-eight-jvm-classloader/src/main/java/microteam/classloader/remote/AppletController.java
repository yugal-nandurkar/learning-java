package microteam.classloader.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applet")
public class AppletController {

    @Autowired
    private AppletManager appletManager;

    @PostMapping("/load")
    public String loadApplet(@RequestParam String appletName) {
        Object applet = appletManager.loadApplet(appletName);
        return "Applet " + appletName + " loaded successfully. Instance: " + applet;
    }

    @GetMapping("/get")
    public Object getApplet(@RequestParam String appletName) {
        Object applet = appletManager.getApplet(appletName);
        if (applet == null) {
            return "Applet " + appletName + " is not loaded.";
        }
        return applet.toString();
    }
}

