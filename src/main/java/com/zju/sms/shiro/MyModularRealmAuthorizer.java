package com.zju.sms.shiro;

import org.apache.shiro.authz.ModularRealmAuthorizer;

/**
 * ModularRealmAuthorizer的doAuthenticate方法使用所有配置的Reaml来进行认证
 * 为了针对不用的登陆类型使用不同Reaml，故写一个子类重写方法
 *  根据Reaml的名字找到正确的Realm
 */
public class MyModularRealmAuthorizer extends ModularRealmAuthorizer {
}
