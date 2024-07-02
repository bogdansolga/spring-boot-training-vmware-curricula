package net.safedata.springboot.training.d01.s06.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Value("#{systemProperties['user.home']}")
    private String userHomeDir;

    @Value("#{environment.acceptsProfiles('dev')}")
    private boolean runsWithDev;

    @Value("#{${APP_PORT}}")
    private String appPort;

    public void displayValues() {
        System.out.println("The user home dir is: " + userHomeDir);
        System.out.println("The app runs with the dev profile: " + runsWithDev);
        System.out.println("The app port is: " + appPort);
    }
}
