package com.bill.serviceucenter.service;

import com.bill.serviceucenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bill.serviceucenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author bill
 * @since 2021-08-15
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember ucenterMember);

    void register(RegisterVo registerVo);

    UcenterMember getOpenIdMember(String openid);
}
