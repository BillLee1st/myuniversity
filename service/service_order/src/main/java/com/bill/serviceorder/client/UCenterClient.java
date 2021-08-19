package com.bill.serviceorder.client;

import com.bill.commonutils.ordervo.UcenterMemberOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/8/19 22:30
 */

@Component
@FeignClient("service-ucenter")
public interface UCenterClient {

    @PostMapping("/serviceucenter/member/getUserInfoOrder/{id}")
    public UcenterMemberOrder getUserInfoOrder(@PathVariable String id);

}
