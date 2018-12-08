package com.zju.sms.controller;

import com.zju.sms.domain.Admin;
import com.zju.sms.domain.AdminPermission;
import com.zju.sms.domain.User;
import com.zju.sms.mapper.AdminPermissionMapper;
import com.zju.sms.mapper.PermissionMapper;
import com.zju.sms.shiro.PermissionName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用来给不同的管理员账号设置权限
 */
@RestController
@Api(value = "修改管理员权限")
public class AdminPermissionController {

    @Autowired
    private AdminPermissionMapper adminPermissionMapper;

/*    @Autowired
    private PermissionMapper permissionMapper;*/
    /**
     * 设置权限方法，要求当前登陆账户为管理员且拥有设置权限的权限
     *
     */
    @RequestMapping(value = "/adminPermissions",method = RequestMethod.POST)
    @RequiresPermissions("permission:edit")
    @PermissionName("权限修改")
    @ApiOperation(value = "修改管理员权限" ,notes = "需要当前登陆账户拥有permission:edit权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adminId",value = "被修改权限的管理员账户id"),
            @ApiImplicitParam(name = "pIds",value = "权限的id数组")
    })
    public String setPermission( @RequestParam Integer adminId, @RequestParam Integer[] pIds){
//        删除该管理员原来的所有权限
            adminPermissionMapper.deleteByAdminId(adminId);
//        添加账号权限映射
        for(Integer pid:pIds){
            AdminPermission ap = new AdminPermission();
            ap.setAdminId(adminId);
            ap.setPermissionId(pid);
            adminPermissionMapper.insert(ap);
        }
        return "success";
    }

}
