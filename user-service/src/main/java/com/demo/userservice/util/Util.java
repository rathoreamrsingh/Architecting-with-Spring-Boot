package com.demo.userservice.util;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Util {
    @LoadBalanced
    @Bean
    public RestTemplate getRestController() {
        return new RestTemplate();
    }
}
