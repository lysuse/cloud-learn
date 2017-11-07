package tech.youngstream.learn.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {

    @RequestMapping(value = "/")
    String home() {
        return "hello";
    }
}
