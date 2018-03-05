package teach.youngstream.cloud.learn.boot.spring_boot04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessAppArgApp {

    public static void main(String[] args) {
        SpringApplication.run(AccessAppArgApp.class, args);
        // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
    }
}
