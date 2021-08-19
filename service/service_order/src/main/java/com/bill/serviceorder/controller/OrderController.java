package com.bill.serviceorder.controller;


import com.bill.commonutils.JwtUtils;
import com.bill.commonutils.R;
import com.bill.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author bill
 * @since 2021-08-15
 */
@RestController
@RequestMapping("/serviceorder/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public R saveOrder(@PathVariable String courseId, HttpServletRequest request) {
        String orderId = orderService.saveOrder(courseId, JwtUtils.getMemberIdByJwtToken(request));
        return R.ok().data("orderId", orderId);
    }

}

