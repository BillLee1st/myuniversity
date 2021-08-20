package com.bill.serviceorder.service.impl;

import com.bill.commonutils.ordervo.CourseWebVoOrder;
import com.bill.commonutils.ordervo.UcenterMemberOrder;
import com.bill.serviceorder.client.EduClient;
import com.bill.serviceorder.client.UCenterClient;
import com.bill.serviceorder.entity.Order;
import com.bill.serviceorder.mapper.OrderMapper;
import com.bill.serviceorder.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bill.serviceorder.utils.OrderNoUtil;
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
    public String saveOrder(String courseId, String memberId) {

        UcenterMemberOrder userInfoOrder = uCenterClient.getUserInfoOrder(memberId);
        CourseWebVoOrder courseInfoOrder = eduClient.getCourseInfoWeb(courseId);

        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo());//订单号
        order.setCourseId(courseId); //课程id
        order.setCourseTitle(courseInfoOrder.getTitle());
        order.setCourseCover(courseInfoOrder.getCover());
        order.setTeacherName(courseInfoOrder.getTeacherName());
        order.setTotalFee(courseInfoOrder.getPrice());
        order.setMemberId(memberId);
        order.setMobile(userInfoOrder.getMobile());
        order.setNickname(userInfoOrder.getNickname());
        order.setStatus(0);  //订单状态（0：未支付 1：已支付）
        order.setPayType(1);  //支付类型 ，微信1
        baseMapper.insert(order);

        return order.getId();
    }
}
