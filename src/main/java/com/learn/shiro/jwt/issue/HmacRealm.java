package com.learn.shiro.jwt.issue;

import com.learn.model.UserModel;
import com.learn.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lunjingjie
 */
public class HmacRealm extends AuthorizingRealm {

    private final UserService userService;

    @Autowired
    public HmacRealm(UserService userService) {
        super();
        setAuthenticationTokenClass(UsernamePasswordToken.class);
        this.userService = userService;
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("-进入授权-");
        //获取当前登陆的用户名
        String userName = (String) principals.fromRealm(getName()).iterator().next();
        Set<String> roleNames = new HashSet<String>();
        roleNames.add("A权限角色");
        Set<String> permissions = new HashSet<String>();
        permissions.add("A权限资源");

        System.out.println(userName + "获取权限角色资源");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * shiro认证方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("-进入认证-");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = String.valueOf(usernamePasswordToken.getUsername());
        String password = new String(usernamePasswordToken.getPassword());
        UserModel user = userService.getUserByName(username, password);
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getUserPassword(), getName());
        return authenticationInfo;
    }
}
