package com.hsbc.fluent;

import com.hsbc.fluent.Config.AppSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AppSettings.class})
public class FluentApplication {

    public static void main(String[] args) {
        SpringApplication.run(FluentApplication.class, args);
    }

}
