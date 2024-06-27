package net.safedata.springboot.training.d01.s06;

import net.safedata.springboot.training.d01.s06.config.ComponentScanConfig;
import net.safedata.springboot.training.d01.s06.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExpressionLanguageMain {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        final ProductService productService = applicationContext.getBean(ProductService.class);
        productService.displayValues();
    }
}
