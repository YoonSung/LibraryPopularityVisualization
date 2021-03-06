package application.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
@ComponentScan({"application.runner","controller"})
@EnableAutoConfiguration
public class LiviApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiviApplication.class, args);
    }
}