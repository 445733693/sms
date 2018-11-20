package com.zju.sms.controller;

import com.zju.sms.domain.Admin;
import com.zju.sms.service.IAdminService;
import com.zju.sms.service.impl.AdminServiceImpl;
import com.zju.sms.util.IPUtils;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @RequestMapping(value = "/admins",method = RequestMethod.POST)
    public String save(@RequestBody Admin admin){
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        admin.setLoginIP(IPUtils.getIpAddr(request));
        adminService.save(admin);
        return "success";
    }

    @RequestMapping(value = "/admins/{adminId}",method = RequestMethod.GET)
    public Admin get(@PathVariable("adminId") String adminId ){
        return adminService.get(adminId);
    }

    @RequestMapping(value = "/admins",method = RequestMethod.GET)
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @RequestMapping(value = "/admins",method = RequestMethod.PUT)
    public String update(@RequestBody Admin admin){
        Admin oldObj = adminService.get(admin.getAdminId());
        UpdateUtil.updateIfNotNull(oldObj,admin);
        adminService.update(oldObj);
        return "success";
    }

    @RequestMapping(value = "/admins/{adminId}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("adminId") String adminId){
        adminService.delete(adminId);
        return "success";
    }
}
