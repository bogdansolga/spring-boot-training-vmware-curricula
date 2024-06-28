package net.safedata.springboot.training.d01.s07.processor;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) {
        // modify the bean definitions in here
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("productService");
        System.out.println("Got the bean definition " + beanDefinition);
    }
}
