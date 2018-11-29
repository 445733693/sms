package com.zju.sms.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 因为原始的UsernamePasswordToken类不含登陆类型信息，故写一个子类
 */
public class UsernamePasswordTypeToken extends UsernamePasswordToken {
    //登陆类型：用户，代理商，管理员
    private String loginType;
    public UsernamePasswordTypeToken(String username,String password,String loginType){
        super(username,password);
        this.loginType=loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
