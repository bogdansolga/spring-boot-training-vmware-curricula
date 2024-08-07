package net.safedata.springboot.training.d05.s01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfig {
    // we need to enable the async processing, otherwise the calls will be handled
    // on the same thread
}
