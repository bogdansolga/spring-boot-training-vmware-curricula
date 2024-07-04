package net.safedata.springboot.training.d05.s01.config;

import net.safedata.springboot.training.d05.s01.service.EmailSendingService;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    private final EmailSendingService emailSendingService;
    private final Executor asyncExecutor;

    @Autowired
    public AsyncConfig(final EmailSendingService emailSendingService,
                       final Executor asyncExecutor) {
        this.emailSendingService = emailSendingService;
        this.asyncExecutor = asyncExecutor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor; // will become the default async executor
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncUncaughtExceptionHandler(emailSendingService);
    }
}
