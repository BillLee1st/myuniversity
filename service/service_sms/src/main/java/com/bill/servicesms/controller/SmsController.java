package com.bill.servicesms.controller;

import com.bill.commonutils.R;
import com.bill.servicesms.service.SmsService;
import com.bill.servicesms.utils.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/8/18 20:46
 */
@RestController
@RequestMapping("servicesms/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public R sendSms(@PathVariable String phone) {

        String code = redisTemplate.opsForValue().get(phone);

        if (StringUtils.isNotEmpty(code)) {
            return R.ok();
        }

        code = RandomUtil.getSixBitRandom();
        Map<String,Object> param = new HashMap<>();
        param.put("code",code);
        boolean isSend = smsService.send(param,phone);

        if (isSend) {
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            return R.ok();
        } else {
            return R.error();
        }
    }
}
