package com.bill.servicesms.service;

import java.util.Map;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/8/18 20:48
 */
public interface SmsService {
    //发送短信的方法
    boolean send(Map<String, Object> param, String phone);
}
