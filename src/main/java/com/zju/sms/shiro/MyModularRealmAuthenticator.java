package com.zju.sms.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.Collection;

/**
 * ModularRealmAuthenticator的doAuthenticate方法使用所有配置的Reaml来进行认证
 * 为了针对不用的登陆类型使用不同Reaml，故写一个子类重写方法
 *  根据Reaml的名字找到正确的Realm
 */

public class MyModularRealmAuthenticator extends ModularRealmAuthenticator {
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
//        判断getRealms()是否为空
        assertRealmsConfigured();
//        强制转换为自定义的UsernamePasswordTypeToken
        UsernamePasswordTypeToken token = (UsernamePasswordTypeToken) authenticationToken;
        String loginType = token.getLoginType();
//        获得所有Realm
        Collection<Realm> realms = getRealms();
        Realm rightrealm=null;
//        根据reaml的名字找到正确的realm
        for(Realm realm:realms){
            if(realm.getName().contains(loginType)){
                rightrealm=realm;
                break;
            }
        }
        return doSingleRealmAuthentication(rightrealm,token);
    }
}
