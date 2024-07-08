package net.safedata.springboot.training.d05.s02.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;
import java.util.concurrent.ScheduledFuture;

@Service
public class TaskSchedulerScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskSchedulerScheduledTasks.class);

    private static final TimeZone CURRENT_TIME_ZONE = TimeZone.getTimeZone("Romania/Bucharest");

    private final TaskScheduler taskScheduler;

    @Autowired
    public TaskSchedulerScheduledTasks(final TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    @PostConstruct
    public void initialize() {
        cronTriggerTask();
        periodicTriggerTask();
    }

    private void cronTriggerTask() {
        final Runnable task = () -> LOGGER.info("[cronTriggerTask] Processing the latest sold products...");
        final CronTrigger cronTrigger = new CronTrigger("1 * * * * MON-FRI", CURRENT_TIME_ZONE);

        final TriggerContext triggerContext = new SimpleTriggerContext(Instant.now(), Instant.now(), Instant.now());
        cronTrigger.nextExecution(triggerContext);

        final ScheduledFuture<?> schedule = taskScheduler.schedule(task, cronTrigger);
        LOGGER.debug("Is it done? - {}", schedule.isDone());
    }

    private void periodicTriggerTask() {
        final Runnable task = () -> LOGGER.info("[periodicTriggerTask] Processing the latest sold products...");
        final PeriodicTrigger periodicTrigger = new PeriodicTrigger(Duration.of(5000, ChronoUnit.MILLIS));

        taskScheduler.schedule(task, periodicTrigger);
    }
}
