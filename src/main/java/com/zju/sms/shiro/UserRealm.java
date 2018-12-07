package com.zju.sms.shiro;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import com.zju.sms.domain.User;
import com.zju.sms.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;
//用户静态权限
//"admins","advices","agents","agentRechargeRecords","announcements","blacklists","channels","contactCategorys","contacts","deductions","expenseRecords","invoiceInfos","keywords","mails","messageDrafts","messageTemplates","phoneLibCategorys","phoneLibs","receiveRecords","rechargeSolutions","sendRecords","systemConfigures","templateCategorys","users","userRechargeRecords","whitelists",
    //用户权限：用户界面功能的权限：修改个人信息，建议，联系人分类，联系人，消费记录，发票，草稿，短信模板，接收记录，发送记录，模板分类，用户充值记录
    private static List<String> permissions= new ArrayList<>(Arrays.asList("users:edit","advices:*","contactCategorys:*",
        "contacts:*","expenseRecords:*","invoiceInfos:*","messageDrafts:*","messageTemplates:*","receiveRecords:*",
        "sendRecords:*","templateCategorys:*","userRechargeRecords:*"));
//    private static List<String> permissions= new ArrayList<>();

    @Override
    public String getName(){
        return "UserRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("UserRealm授权.......");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("终端用户认证....");
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
