package com.g1335333249;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JenkinsChinaMirrorsConvertApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsChinaMirrorsConvertApplication.class, args);
    }

}
