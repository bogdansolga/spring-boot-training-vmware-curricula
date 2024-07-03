package net.safedata.springboot.training.d05.s03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot class which demos the usage of {@link org.springframework.scheduling.TaskScheduler}s
 *
 * @author bogdan.solga
 */
@SpringBootApplication
public class TaskSchedulingDemo {

    public static void main(String[] args) {
        new SpringApplication(TaskSchedulingDemo.class).run(args);
    }
}
