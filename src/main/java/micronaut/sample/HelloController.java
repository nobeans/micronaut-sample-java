package micronaut.sample;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloController {

    @Get(produces = MediaType.TEXT_PLAIN) // producesを指定しない場合、デフォルトはJSON
    public String index() {
        return "Hello, Micronaut!";
    }
}
