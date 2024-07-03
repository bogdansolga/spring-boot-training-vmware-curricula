package net.safedata.springboot.training.d05.s01.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@Component
public class AsyncComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncComponent.class);

    private final Executor shortLivedTaskExecutor;

    @Autowired
    public AsyncComponent(final Executor shortLivedTaskExecutor) {
        this.shortLivedTaskExecutor = shortLivedTaskExecutor;
    }

    @Async("longLivedTaskExecutor")
    void voidAsyncCall() {
        displayCurrentThread();
        LOGGER.info("Displaying a value asynchronously");
    }

    @Async("shortLivedTasksExecutor")
    Future<String> getFuture() {
        displayCurrentThread();
        return new AsyncResult<>("Returning a Future async value");
    }

    @Async // the default executor is used
    CompletableFuture<String> getCompletableFuture() {
        displayCurrentThread();
        return CompletableFuture.supplyAsync(() -> "Returned by the CompletableFuture", shortLivedTaskExecutor);
    }

    private void displayCurrentThread() {
        LOGGER.info("Running on the thread '{}'", Thread.currentThread().getName());
    }
}
