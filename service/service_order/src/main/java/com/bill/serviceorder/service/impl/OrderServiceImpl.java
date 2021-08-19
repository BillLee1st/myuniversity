package com.bill.serviceorder.service.impl;

import com.bill.commonutils.ordervo.UcenterMemberOrder;
import com.bill.serviceorder.client.EduClient;
import com.bill.serviceorder.client.UCenterClient;
import com.bill.serviceorder.entity.Order;
import com.bill.serviceorder.mapper.OrderMapper;
import com.bill.serviceorder.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author bill
 * @since 2021-08-15
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private EduClient eduClient;


    @Autowired
    @Qualifier("UCenterClient")
    private UCenterClient uCenterClient;

    @Override
    public String saveOrder(String courseId, String memberIdByJwtToken) {

        UcenterMemberOrder userInfoOrder = uCenterClient.getUserInfoOrder(memberIdByJwtToken);

        return null;
    }
}
