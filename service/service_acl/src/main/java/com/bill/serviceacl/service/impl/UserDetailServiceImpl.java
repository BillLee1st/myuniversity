package com.bill.serviceacl.service.impl;

import com.bill.security.entity.SecurityUser;
import com.bill.serviceacl.entity.User;
import com.bill.serviceacl.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/9/19 13:26
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionServiceImpl permissionService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.selectByUsername(username);

        if (null == user) {
            throw new UsernameNotFoundException("this user does not exist");
        }

        com.bill.security.entity.User curUser = new com.bill.security.entity.User();
        BeanUtils.copyProperties(user, curUser);


        List<String> authorities = permissionService.selectPermissionValueByUserId(user.getId());
        SecurityUser securityUser = new SecurityUser(curUser);
        securityUser.setPermissionValueList(authorities);

        return securityUser;
    }
}
