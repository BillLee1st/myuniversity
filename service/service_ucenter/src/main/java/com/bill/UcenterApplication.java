package com.bill;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bill"})
@MapperScan("com.bill.serviceucenter.mapper")
public class UcenterApplication{
    public static void main( String[] args ){
        SpringApplication.run(UcenterApplication.class, args);
    }
}
