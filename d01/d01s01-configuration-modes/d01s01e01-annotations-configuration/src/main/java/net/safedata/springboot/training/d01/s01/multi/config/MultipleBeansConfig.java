package net.safedata.springboot.training.d01.s01.multi.config;

import net.safedata.springboot.training.d01.s01.multi.beans.HelloSpring;
import net.safedata.spring.training.domain.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * Sample Spring configuration, which exposes several simple {@link Bean}s
 *
 * @author bogdan.solga
 */
@Configuration
@SuppressWarnings("unused")
public class MultipleBeansConfig {

    // the method 'helloSpring' creates a HelloSpring bean, as it has the @Bean annotation
    @Bean
    public HelloSpring helloSpring() {
        return new HelloSpring();
    }

    @Bean
    public HelloSpring otherHelloSpring() {
        return new HelloSpring();
    }

    @Bean
    public Product product() {
        return new Product(1, "Tablet", 200d);
    }

    @Bean
    public String helloSpringAsString() {
        return "Hello, Spring [as a string]!";
    }

    @Bean
    public Boolean booleanBean() {
        return Boolean.TRUE;
    }

    @Bean
    public int randomBean() {
        return new Random(100).nextInt();
    }
}
