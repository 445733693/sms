package com.zju.sms.controller;

import com.zju.sms.shiro.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 加载权限
 */
@RestController
public class LoadPermissionsController {
    @Autowired
    private ResourceLoader resourceLoader;
    @RequestMapping("/loadPermissions")
    public void load() throws Exception {
        ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        MetadataReaderFactory metaReader = new CachingMetadataReaderFactory(resourceLoader);
        Resource[] resources = resolver.getResources("classpath*:com/zju/sms/controller/*.class");

        for (Resource r : resources) {
            MetadataReader reader = metaReader.getMetadataReader(r);
            Class<?> clz = Class.forName(reader.getClassMetadata().getClassName());//获取Controller类对象
            PermissionName permissionName = clz.getAnnotation(PermissionName.class);//获取类上的PermissionName注解
            String name = permissionName==null?null:permissionName.value()[0];
            RequiresPermissions requiresPermissions = clz.getAnnotation(RequiresPermissions.class);//获取类上的RequiresPermissions注解
            String permision = requiresPermissions==null?null:requiresPermissions.value()[0];
            if(name!=null&&permision!=null){
//                System.out.println("name="+name+";permision="+permision);
                System.out.print("\""+permision+"\""+",");
            }

        }

    }
}
