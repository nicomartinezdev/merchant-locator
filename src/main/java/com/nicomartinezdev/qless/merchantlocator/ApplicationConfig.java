package com.nicomartinezdev.qless.merchantlocator;

import com.nicomartinezdev.qless.merchantlocator.controllers.VersionController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.inject.Inject;

/**
 * Created by nicolasmartinez on 2/19/18.
 */
@Configuration
@PropertySource("classpath:messages.properties")
@EnableAutoConfiguration(exclude = MongoRepositoriesAutoConfiguration.class)
@EnableMongoRepositories(basePackages = "com.nicomartinezdev.qless.merchantlocator.repositories")
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    @Value("${build.version}")
    private String buildVersion;

    @Value("${build.timestamp}")
    private String buildTimestamp;

    private final MongoOperations mongoOperations;

    @Inject
    public ApplicationConfig(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Bean
    public VersionController versionController() {
        return new VersionController(buildVersion, buildTimestamp);
    }
}
