package com.bill.servicesms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/8/18 20:41
 */

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.bill")
public class SmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }

}
