package com.zju.sms.shiro;

import com.zju.sms.domain.Agent;
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
import java.util.Arrays;
import java.util.List;

public class AgentRealm extends AuthorizingRealm{
    @Autowired
    private IAgentService agentService;
//代理商静态权限
    private static List<String> permissions= new ArrayList<>(Arrays.asList(
            "agentRechargeRecords:*","expenseRecords:*","keywords:*","mails:*",
            "receiveRecords:*","sendRecords:*","users:*","userRechargeRecords:*"));

    @Override
    public String getName() {
        return "AgentRealm";
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("AgentRealm授权.......");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordTypeToken token = (UsernamePasswordTypeToken) authenticationToken;
        String username = token.getUsername();
        Agent agent = agentService.getByUsername(username);
        if(agent==null) return null;
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, agent.getPassword(), getName());
        return info;
    }
}
