package com.bill;

import com.bill.serviceedu.EduApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.bill"})
public class UcenterApplication{
    public static void main( String[] args ){
        SpringApplication.run(EduApplication.class, args);
    }
}
