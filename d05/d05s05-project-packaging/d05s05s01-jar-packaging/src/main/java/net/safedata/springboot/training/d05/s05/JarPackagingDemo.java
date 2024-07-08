package net.safedata.springboot.training.d05.s05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A small Spring Boot demo for packaging and running the app
 *
 * @author bogdan.solga
 */
@SpringBootApplication
public class JarPackagingDemo {

    public static void main(String[] args) {
        SpringApplication.run(JarPackagingDemo.class, args);
    }
}