package com.zju.sms.controller;

import com.zju.sms.domain.Permission;
import com.zju.sms.mapper.PermissionMapper;
import com.zju.sms.shiro.PermissionName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 加载权限
 */
@RestController
public class LoadPermissionsController {
/*    @Autowired
    private ResourceLoader resourceLoader;*/

    @Autowired
    @Qualifier("requestMappingHandlerMapping")
    private RequestMappingHandlerMapping rmhm;

    @Autowired
    private PermissionMapper permissionMapper;

    @RequestMapping("/loadPermissions")
    public void load() throws Exception {
        System.out.println("加载权限.....");
//        获取已存在的权限，方式重复加载
        List<Permission> permissions = permissionMapper.selectAll();
        List<String> pList=new ArrayList<>();
        for(Permission p:permissions){
            pList.add(p.getResource());
        }
        //获取所有controller中所有带@RequestMapping标签的方法
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
        Collection<HandlerMethod> methods = handlerMethods.values();
//        遍历方法，判断是否有@RequiresPermission标签和自定义的@PermissionName标签
        for(HandlerMethod method:methods){
//            获取标签
            RequiresPermissions rq = method.getMethodAnnotation(RequiresPermissions.class);
            if(rq!=null){
//                获取权限表达式
                String resource = rq.value()[0];
//                权限已存在，则跳过
                if(pList.contains(resource)){
                    continue;
                }
//                获取权限名
                String name = method.getMethodAnnotation(PermissionName.class).value()[0];
//                System.out.println(name+":"+resource);
//                权限存入数据库
                Permission permission = new Permission();
                permission.setName(name);
                permission.setResource(resource);
                permissionMapper.insert(permission);
            }
        }
    }



    /*@RequestMapping("/loadPermissions")
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

    }*/
}