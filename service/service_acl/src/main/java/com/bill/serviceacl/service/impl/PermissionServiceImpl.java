package com.bill.serviceacl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bill.serviceacl.entity.Permission;
import com.bill.serviceacl.entity.User;
import com.bill.serviceacl.mapper.PermissionMapper;
import com.bill.serviceacl.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bill.serviceacl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 * @author bill
 * @since 2021-08-22
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private UserService userService;

    @Override
    public List<Permission> queryAllMenu() {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<Permission> permissionList = baseMapper.selectList(wrapper);
        List<Permission> result = build(permissionList);
        return result;
    }



    public static List<Permission> build(List<Permission> treeNodes) {
        List<Permission> trees = new ArrayList<>();
        treeNodes.forEach(treeNode ->{
            if ("0".equals(treeNode.getPid())) {
                treeNode.setLevel(1);
                trees.add(findChildren(treeNode,treeNodes));
            }
        });
        return trees;
    }

    public static Permission findChildren(Permission treeNode, List<Permission> treeNodes) {

        List<Permission> childrenNodes = new ArrayList<>();
        treeNodes.forEach(childrenNode -> {
            if (treeNode.getId().equals(childrenNode.getPid())) {
                int level = treeNode.getLevel() + 1;
                childrenNode.setLevel(level);
                childrenNodes.add(findChildren(childrenNode, treeNodes));
            }
        });
        treeNode.setChildren(childrenNodes);
        return treeNode;
    }

    @Override
    public void deletePermission(String id) {
        List<String> idList = new ArrayList<>();
        this.selectIdListById(id, idList);

        idList.add(id);
        idList.forEach(e-> System.out.println(e));
//        baseMapper.deleteBatchIds(idList);
    }

    @Override
    public List<String> selectPermissionValueByUserId(String userId) {

        List<String> permissionValueList = null;

        if (isSysadmin(userId)) {
            permissionValueList = baseMapper.selectAllPermissionValue();
        }else {
            permissionValueList = baseMapper.selectPermissionValueByUserId(userId);
        }

        return permissionValueList;
    }


    public boolean isSysadmin(String userId) {
        User user = userService.getById(userId);

        if (null != user && "admin".equals(user.getUsername())) {
            return true;
        }else{
            return false;
        }
    }

    private void selectIdListById(String id, List<String> idList) {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.eq("pid",id);
        List<Permission> childIdList = baseMapper.selectList(wrapper);

       childIdList.stream().forEach(e->{
           idList.add(e.getId());
            this.selectIdListById(e.getId(), idList);
       });


    }

}
