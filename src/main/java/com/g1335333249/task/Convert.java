package com.g1335333249.task;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * @author guanpeng
 * @date 2019-10-31 17:27
 */
@Component
@Slf4j
public class Convert {

    private static final String tsinghuaURL = "https://mirrors.tuna.tsinghua.edu.cn/jenkins/updates/update-center.json";

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0 0 1 * * *")
    @PostConstruct
    public void exec() {
        String template = restTemplate.getForObject(tsinghuaURL, String.class);
        assert template != null;

    }
}
