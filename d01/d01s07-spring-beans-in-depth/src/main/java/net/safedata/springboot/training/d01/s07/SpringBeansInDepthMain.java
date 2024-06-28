package net.safedata.springboot.training.d01.s07;

import net.safedata.springboot.training.d01.s07.config.ComponentScanConfig;
import net.safedata.springboot.training.d01.s07.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeansInDepthMain {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        final ProductService productService = applicationContext.getBean(ProductService.class);
        productService.displayAllProducts();
    }
}
