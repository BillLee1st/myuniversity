package com.bill.serviceucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bill.commonutils.JwtUtils;
import com.bill.servicebase.exceptionHandler.CustomException;
import com.bill.serviceucenter.entity.UcenterMember;
import com.bill.serviceucenter.mapper.UcenterMemberMapper;
import com.bill.serviceucenter.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author bill
 * @since 2021-08-15
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    @Override
    public String login(UcenterMember ucenterMember) {

        String mobile = ucenterMember.getMobile();
        String password = ucenterMember.getPassword();

        //手机号和密码非空判断
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
            throw new CustomException(20001,"登录失败");
        }

        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        UcenterMember mobileMember = baseMapper.selectOne(wrapper);
        //判断查询对象是否为空
        if(mobileMember == null) {//没有这个手机号
            throw new CustomException(20001,"登录失败");
        }

        String token = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());
        return token;
    }
}
