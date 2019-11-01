package com.g1335333249.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

/**
 * @author guanpeng
 * @date 2019-11-01 08:50
 */
@Controller
@RequestMapping("download")
@Slf4j
public class ConvertController {
    private static final String URL = "https://mirrors.tuna.tsinghua.edu.cn/jenkins";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/**")
    public String convert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI().substring(9);
        log.info("uri is {}", uri);
        log.info("tsinghua url is {}{}", URL, uri);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
        ResponseEntity<byte[]> pluginResponse = restTemplate.exchange(URL + uri, HttpMethod.GET, new HttpEntity<byte[]>(headers), byte[].class);
        response.getOutputStream().write(Objects.requireNonNull(pluginResponse.getBody()));
        return null;
    }
}
