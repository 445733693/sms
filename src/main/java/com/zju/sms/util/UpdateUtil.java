package com.zju.sms.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class UpdateUtil {
    /**
     * 该方法用新对象中非null的属性更新旧对象中的属性
     * @param oldObj 旧对象
     * @param newObj 新对象
     *
     */
    public static void updateIfNotNull(Object oldObj,Object newObj)  {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(oldObj.getClass(), Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor pd:pds){
                Method readMethod = pd.getReadMethod();
                Object value = readMethod.invoke(newObj);
                if(value!=null){
                    Method writeMethod = pd.getWriteMethod();
                    writeMethod.invoke(oldObj,value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
