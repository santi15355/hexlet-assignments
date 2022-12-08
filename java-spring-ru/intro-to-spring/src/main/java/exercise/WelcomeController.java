package exercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
public class WelcomeController {
    @GetMapping("/")
    public String getGreeting() {
        return "Welcome to Spring";
    }

    @GetMapping("/hello")
    public String getName(@RequestParam(required = false) String name) {
        return name == null ? "Hello, World" : "Hello, " + name;
    }
}
// END
