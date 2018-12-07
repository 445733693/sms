package com.zju.sms.controller;

import com.zju.sms.domain.SystemConfigure;
import com.zju.sms.service.ISystemConfigureService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiresPermissions("systemConfigures")
@PermissionName("系统设置")
public class SystemConfigureController {
    @Autowired
    private ISystemConfigureService systemConfigureService;

    @RequestMapping(value = "/systemConfigures",method = RequestMethod.POST)
    public String saveSystemConfigure(@RequestBody SystemConfigure systemConfigure){
        systemConfigureService.save(systemConfigure);
        return"success";
    }
    @RequestMapping(value = "/systemConfigures",method = RequestMethod.PUT)
    public String updateSystemConfigure(@RequestBody SystemConfigure systemConfigure){
        SystemConfigure old = systemConfigureService.get(systemConfigure.getId());
        UpdateUtil.updateIfNotNull(old,systemConfigure);
        systemConfigureService.update(old);
        return"success";
    }
    @RequestMapping(value = "/systemConfigures/{id}",method = RequestMethod.DELETE)
    public String deleteSystemConfigure(@PathVariable("id") Integer id){
        systemConfigureService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/systemConfigures/{id}",method = RequestMethod.GET)
    public SystemConfigure getSystemConfigure(@PathVariable("id") Integer id){
        return systemConfigureService.get(id);
    }
    @RequestMapping(value = "/systemConfigures",method = RequestMethod.GET)
    public List<SystemConfigure> getAdvice(){
        return systemConfigureService.getAll();
    }
}
