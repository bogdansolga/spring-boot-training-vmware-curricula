package net.safedata.springboot.training.d01.s07.config;

import net.safedata.springboot.training.d01.s07.processor.CustomBeanFactoryPostProcessor;
import net.safedata.springboot.training.d01.s07.processor.CustomBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorsConfig {

    @Bean
    public CustomBeanFactoryPostProcessor customProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }

    @Bean
    public CustomBeanPostProcessor beanPostProcessor() {
        return new CustomBeanPostProcessor();
    }
}
