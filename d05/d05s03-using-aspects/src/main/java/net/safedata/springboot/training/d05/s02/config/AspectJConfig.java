package net.safedata.springboot.training.d05.s02.config;

import net.safedata.springboot.training.d05.s02.aop.aspect.LoggingAspect;
import net.safedata.springboot.training.d05.s02.aop.aspect.ProfilingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectJConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public ProfilingAspect profiler() {
        return new ProfilingAspect();
    }
}
