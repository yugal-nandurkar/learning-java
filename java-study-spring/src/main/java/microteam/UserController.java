package microteam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/greet")
    public String greetUser(@RequestParam(name="name", required=false, defaultValue="Guest") String name, Model model) {
        model.addAttribute("username", name);
        return "greeting";
    }
}
