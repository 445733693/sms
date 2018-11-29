package com.zju.sms.shiro;

import com.zju.sms.domain.User;
import com.zju.sms.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    @Override
    public String getName(){
        return "UserRealm";
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权.....");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证....");
        UsernamePasswordTypeToken token= (UsernamePasswordTypeToken)authenticationToken;
//        获取被验证的用户名
        String username = token.getUsername();
//        根据用户名从数据库获取用户对象
        User user = userService.getByUsername(username);
//        用户不存在，抛出异常
        if(user==null){
            throw new UnknownAccountException("用户不存在");
        }
//        这里的第一个参数principle可以是对象
//        待完成：密码加密，加盐
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
        return info;
    }
}
