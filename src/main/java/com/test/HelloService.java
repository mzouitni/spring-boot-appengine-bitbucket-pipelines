package hello;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

  public HelloService() {
  }

  public String sayHello() {
    return "Hello World!";
  }
}
