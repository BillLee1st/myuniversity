package com.bill.serviceorder.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/8/19 22:23
 */

@Component
@FeignClient("service-edu")
public interface EduClient {

}
