package micronaut.sample;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloControllerTest {

    @Test
    public void testIndex() throws Exception {
        try (EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class)) {
            try (RxHttpClient client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL())) {
                assertEquals("Hello, Micronaut!", client.toBlocking().retrieve("/hello"));
            }
        }
    }
}
