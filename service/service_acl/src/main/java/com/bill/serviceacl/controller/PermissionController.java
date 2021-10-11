package com.bill.serviceacl.controller;


import com.bill.commonutils.R;
import com.bill.serviceacl.entity.Permission;
import com.bill.serviceacl.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author bill
 * @since 2021-08-22
 */
@RestController
@RequestMapping("/serviceacl/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("getAllMenu")
    public R indexAllPermission() {
        List<Permission> list = permissionService.queryAllMenu();
        return R.ok().data("list",list);
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("deleteMenu")
    public R deletePermission(String id) {
        permissionService.deletePermission(id);
        return R.ok();
    }

}

