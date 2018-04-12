package com.learn.shiro;

import com.learn.model.UserModel;
import com.learn.service.UserService;
import com.learn.util.JWTUtil;
import org.apache.log4j.LogManager;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

    private final UserService userService;

    @Autowired
    public MyRealm(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 在token中解密出用户名
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invaild");
        }

        UserModel userModel = userService.getUserByName(username);
        if (userModel == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (JWTUtil.vertify(token, username, userModel.getUserPassword())) {
            throw new AuthorizationException("Username or Password erroe");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
