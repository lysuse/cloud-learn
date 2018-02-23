package teach.youngstream.cloud.learn.boot.spring_boot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YoungStream on 2017/3/21.
 */
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Example.class,args);
    }

}
