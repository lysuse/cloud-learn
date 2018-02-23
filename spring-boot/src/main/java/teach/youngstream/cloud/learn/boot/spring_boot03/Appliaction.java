package teach.youngstream.cloud.learn.boot.spring_boot03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by YoungStream on 2017/3/21.
 */
@SpringBootApplication
//与@Configuration @EnableAutoConfiguration @ComponentScan一样的注解
public class Appliaction {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled","false");
        SpringApplication.run(Appliaction.class, args);
    }
}
