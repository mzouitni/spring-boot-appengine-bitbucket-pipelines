package hello;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import org.springframework.stereotype.Component;

import static hello.EventType.GET_USER;
import static io.vertx.core.http.HttpMethod.GET;

/**
 * Simple web server verticle to expose the results of the Spring service bean call (routed via a verticle - see
 * SpringDemoVerticle)
 *
 * @author Mouad Zouitni
 * @since August 15, 2017
 */
@Component
public class UserVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    super.start();
    HttpServer server = vertx.createHttpServer();
    server.requestHandler(req -> {
      if (req.method() == GET) {
        req.response().setChunked(true);

        if (req.path().equals("/users")) {
          vertx.eventBus().<String>send(GET_USER.name(), "", result -> {
            if (result.succeeded()) {
              req.response().setStatusCode(200).write(result.result().body()).end();
            } else {
              req.response().setStatusCode(500).write(result.cause().toString()).end();
            }
          });
        } else {
          req.response().setStatusCode(200).write("Hello from vert.x").end();
        }

      } else {
        // We only support GET for now
        req.response().setStatusCode(405).end();
      }
    });

    server.listen(8081);
  }
}
