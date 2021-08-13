package com.bill.serviceedu.controller;

import com.bill.commonutils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/5/29 14:28
 */
@RestController
@RequestMapping("/eduService/user")
@CrossOrigin
public class EduLoginController {

    @PostMapping("login")
    public R login() {
        return R.ok().data("token", "admin");
    }

    @GetMapping("getInfo")
    public R getInfo() {
        return R.ok().data("roles", "[admin]").data("name", "admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
