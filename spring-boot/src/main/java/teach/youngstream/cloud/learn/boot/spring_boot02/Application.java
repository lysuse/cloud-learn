package teach.youngstream.cloud.learn.boot.spring_boot02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by YoungStream on 2017/3/21.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import(value = {XmlImport.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
