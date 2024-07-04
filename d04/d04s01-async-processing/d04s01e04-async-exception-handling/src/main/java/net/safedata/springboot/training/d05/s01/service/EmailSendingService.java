package net.safedata.springboot.training.d05.s01.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSendingService.class);

    public void sendEmailWithException(Throwable throwable) {
        LOGGER.info("Sending the email for '{}'...", throwable.getMessage());
        // TODO send the email
    }
}
