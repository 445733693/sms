package com.zju.sms.shiro;

/**
 * 登陆类型
 * 标识不同的登陆用户
 * 当配置多个Realm时，通常使用的认证器是shiro自带的ModularRealmAuthenticator，用于在doAuthenticate方法中决定使用哪个Realm
 */
public enum LoginType {
    USER("User"),AGENT("Agent"),ADMIN("Admin");
    private String type;
    private LoginType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
