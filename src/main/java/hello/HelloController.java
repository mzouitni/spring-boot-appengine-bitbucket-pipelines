package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    private UserService service;

    @Autowired
    public HelloController(UserService userService) {
        this.service = userService;
    }
    @RequestMapping("/")
    public String index() {
        return service.sayHello();
    }
    
}
