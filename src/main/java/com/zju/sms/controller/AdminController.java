package com.zju.sms.controller;

import com.zju.sms.domain.Admin;
import com.zju.sms.service.IAdminService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @RequestMapping(value = "/admins",method = RequestMethod.POST)
    @RequiresPermissions("admins:save")
    @PermissionName("管理员账户添加")
    public String saveAdmin(@RequestBody Admin admin){

        adminService.save(admin);
        return"success";
    }
    @RequestMapping(value = "/admins",method = RequestMethod.PUT)
    @RequiresPermissions("admins:edit")
    @PermissionName("管理员账户修改")
    public String updateAdmin(@RequestBody Admin admin){
        Admin old = adminService.get(admin.getId());
        UpdateUtil.updateIfNotNull(old,admin);
        adminService.update(old);
        return"success";
    }
    @RequestMapping(value = "/admins/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("admins:delete")
    @PermissionName("管理员账户删除")
    public String deleteAdmin(@PathVariable("id") Integer id){
        adminService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/admins/{id}",method = RequestMethod.GET)
    @RequiresPermissions("admins:get")
    @PermissionName("管理员账户查询")
    public Admin getAdmin(@PathVariable("id") Integer id){
        return adminService.get(id);
    }

    @RequestMapping(value = "/admins",method = RequestMethod.GET)
    @RequiresPermissions("admins:list")
    @PermissionName("管理员账户列表")
    public List<Admin> getAdvice(){
        return adminService.getAll();
    }
   /* @RequestMapping(value = "/admins",method = RequestMethod.GET)
    public Admin getAdminUser(@RequestBody String username){
        return adminService.getByUsername(username);
    }*/
}
