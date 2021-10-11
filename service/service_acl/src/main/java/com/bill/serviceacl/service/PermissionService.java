package com.bill.serviceacl.service;

import com.bill.serviceacl.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author bill
 * @since 2021-08-22
 */
public interface PermissionService extends IService<Permission> {

    List<Permission> queryAllMenu();

    void deletePermission(String id);

    //根据用户id获取用户菜单
    List<String> selectPermissionValueByUserId(String id);

}
