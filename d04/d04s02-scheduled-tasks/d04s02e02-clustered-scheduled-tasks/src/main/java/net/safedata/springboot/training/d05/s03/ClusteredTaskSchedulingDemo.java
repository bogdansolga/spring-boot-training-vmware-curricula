package net.safedata.springboot.training.d05.s03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot class which demos the usage of Quartz scheduled tasks
 *
 * @author bogdan.solga
 */
@SpringBootApplication
public class ClusteredTaskSchedulingDemo {

    public static void main(String[] args) {
        new SpringApplication(ClusteredTaskSchedulingDemo.class).run(args);
    }
}
