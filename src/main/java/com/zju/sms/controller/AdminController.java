package com.zju.sms.controller;

import com.zju.sms.domain.Admin;
import com.zju.sms.service.IAdminService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @RequestMapping(value = "/admins",method = RequestMethod.POST)
    public String saveAdmin(@RequestBody Admin admin){
        adminService.save(admin);
        return"success";
    }
    @RequestMapping(value = "/admins",method = RequestMethod.PUT)
    public String updateAdmin(@RequestBody Admin admin){
        Admin old = adminService.get(admin.getId());
        UpdateUtil.updateIfNotNull(old,admin);
        adminService.update(old);
        return"success";
    }
    @RequestMapping(value = "/admins/{id}",method = RequestMethod.DELETE)
    public String deleteAdmin(@PathVariable("id") Integer id){
        adminService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/admins/{id}",method = RequestMethod.GET)
    public Admin getAdmin(@PathVariable("id") Integer id){
        return adminService.get(id);
    }
    @RequestMapping(value = "/admins",method = RequestMethod.GET)
    public List<Admin> getAdvice(){
        return adminService.getAll();
    }
   /* @RequestMapping(value = "/admins",method = RequestMethod.GET)
    public Admin getAdminUser(@RequestBody String username){
        return adminService.getByUsername(username);
    }*/
}
