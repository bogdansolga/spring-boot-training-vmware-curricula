package net.safedata.spring.boot.training.d03.s02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "net.safedata.spring.boot.training.d03.s02.repository")
public class MongoDBConfig {
}
