package teach.youngstream.cloud.learn.boot.spring_boot06_24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private RandomProperties randomProperties;

    @GetMapping("/app")
    public String app() {
        return randomProperties.toString();
    }

    @GetMapping("/rest")
    public RandomProperties rest() {
        return randomProperties;
    }
}
