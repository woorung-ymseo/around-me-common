package com.around.me.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableEurekaClient // eureka client
@EnableCircuitBreaker // hystrix
@EnableHystrix // hystrix
@EnableJpaRepositories
@SpringBootApplication
public class AroundMeCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AroundMeCommonApplication.class, args);
    }

}
