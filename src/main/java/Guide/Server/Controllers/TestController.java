package Guide.Server.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TestController {

    @RequestMapping("")
    String test() {
        return "Серега, у нас теперь есть тестовый сервер!";
    }
}
