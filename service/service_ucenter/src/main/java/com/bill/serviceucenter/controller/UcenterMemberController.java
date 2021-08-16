package com.bill.serviceucenter.controller;


import com.bill.commonutils.R;
import com.bill.serviceucenter.entity.UcenterMember;
import com.bill.serviceucenter.entity.vo.RegisterVo;
import com.bill.serviceucenter.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author bill
 * @since 2021-08-15
 */
@RestController
@RequestMapping("/serviceucenter/member")
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService ucenterMemberService;

    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember ucenterMember) {
        String token = ucenterMemberService.login(ucenterMember);
        return R.ok().data("token", token);
    }

    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo) {
        ucenterMemberService.register(registerVo);
        return R.ok();
    }


}

