package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static hello.EventType.GET_USER;

/**
 * Handles all events the user system is interested in.
 *
 * @author Mouad Zouitni
 * @since August 16, 2017
 */
@Component
public class UserEventHandler extends AbstractVerticle {
  // Reuse the Vert.x Mapper, alternatively you can use your own.
  private final ObjectMapper mapper = Json.mapper;

  private UserService service;

  @Autowired
  public UserEventHandler(UserService service) {
    this.service = service;
  }

  private Handler<Message<String>> allProductsHandler() {
    // It is important to use an executeBlocking construct here
    // as the service calls are blocking (dealing with a database)
    return msg -> vertx.<String>executeBlocking(future -> {
        try {
          //future.complete(mapper.writeValueAsString(service.sayHello()));
          future.complete(service.sayHello());
        } //catch (JsonProcessingException e) {
        catch (Exception e) {
          System.out.println("Failed to serialize result");
          future.fail(e);
        }
      },
      result -> {
        if (result.succeeded()) {
          msg.reply(result.result());
        } else {
          msg.reply(result.cause().toString());
        }
      });
  }

  @Override
  public void start() throws Exception {
    super.start();
    vertx.eventBus().<String>consumer(GET_USER.name()).handler(allProductsHandler());
  }
}
