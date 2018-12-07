package com.zju.sms.shiro;

import com.zju.sms.domain.Admin;
import com.zju.sms.domain.Agent;
import com.zju.sms.service.IAdminService;
import com.zju.sms.service.IAgentService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AdminRealm extends AuthorizingRealm {
    @Autowired
    private IAdminService adminService;

    @Override
    public String getName() {
        return "AdminRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("AdminRealm授权.......");
        List<String> permissions= new ArrayList<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordTypeToken token = (UsernamePasswordTypeToken) authenticationToken;
        String username = token.getUsername();
        Admin admin = adminService.getByUsername(username);
        if(admin==null) return null;
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, admin.getPassword(), getName());
        return info;
    }
}
