package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

  private HelloService service;

  @Autowired
  public HelloController(HelloService userService) {
    this.service = userService;
  }

  @RequestMapping("/")
  public String index() {
    return service.sayHello();
  }
}
