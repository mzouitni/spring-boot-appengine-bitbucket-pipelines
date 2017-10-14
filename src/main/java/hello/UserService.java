package hello;

import org.springframework.stereotype.Service;

/**
 * Manages user related functionality.
 *
 * @author Mouad Zouitni
 * @since August 15, 2017
 */
@Service
public class UserService {


  public UserService() {

  }

  public String sayHello() {
    return "Helloooo!!!";
  }
}
