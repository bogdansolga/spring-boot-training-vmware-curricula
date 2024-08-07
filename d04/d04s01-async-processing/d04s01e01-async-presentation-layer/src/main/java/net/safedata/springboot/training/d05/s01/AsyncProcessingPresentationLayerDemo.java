package net.safedata.springboot.training.d05.s01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot class which demos the async processing on the presentation layer
 *
 * @author bogdan.solga
 */
@SpringBootApplication
public class AsyncProcessingPresentationLayerDemo {

    public static void main(String[] args) {
        new SpringApplication(AsyncProcessingPresentationLayerDemo.class).run(args);
    }
}
