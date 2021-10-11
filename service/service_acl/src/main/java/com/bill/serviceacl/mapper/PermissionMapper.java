package com.bill.serviceacl.mapper;

import com.bill.serviceacl.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author bill
 * @since 2021-08-22
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<String> selectAllPermissionValue();

    List<String> selectPermissionValueByUserId(String userId);

}
