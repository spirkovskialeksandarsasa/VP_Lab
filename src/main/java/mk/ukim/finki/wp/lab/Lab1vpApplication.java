package mk.ukim.finki.wp.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@EntityScan
public class Lab1vpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1vpApplication.class, args);
    }

}
