package com.bill.serviceorder.service.impl;

import com.bill.serviceorder.entity.PayLog;
import com.bill.serviceorder.mapper.PayLogMapper;
import com.bill.serviceorder.service.PayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author bill
 * @since 2021-08-15
 */
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

}
