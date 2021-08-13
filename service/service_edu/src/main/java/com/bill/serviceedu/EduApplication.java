package com.bill.serviceedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/5/16 14:50
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bill"})
@MapperScan("com.bill.serviceedu.mapper")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
