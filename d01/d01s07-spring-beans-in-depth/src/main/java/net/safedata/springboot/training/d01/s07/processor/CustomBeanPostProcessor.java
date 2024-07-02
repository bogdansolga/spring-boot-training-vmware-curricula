package net.safedata.springboot.training.d01.s07.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[before] Current bean is '" + beanName + "', class is " + bean.getClass().getSimpleName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[after] Current bean is '" + beanName + "', class is " + bean.getClass().getSimpleName());
        return bean;
    }
}
