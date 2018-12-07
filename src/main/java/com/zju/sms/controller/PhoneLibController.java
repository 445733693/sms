package com.zju.sms.controller;

import com.zju.sms.domain.PhoneLib;
import com.zju.sms.service.IPhoneLibService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneLibController{
    @Autowired
    private IPhoneLibService phoneLibService;
    /**
     * 添加号码库
     * @param phoneLib 号码库对象
     * @return 添加成功的标志
     */
    @RequestMapping(value = "/phoneLibs",method = RequestMethod.POST)
    @RequiresPermissions("phoneLibs:save")
    @PermissionName("号码库添加")
    public String savePhoneLib(@RequestBody PhoneLib phoneLib){
        phoneLibService.save(phoneLib);
        return"success";
    }
    @RequestMapping(value = "/phoneLibs",method = RequestMethod.PUT)
    @RequiresPermissions("phoneLibs:edit")
    @PermissionName("号码库修改")
    public String updatePhoneLib(@RequestBody PhoneLib phoneLib){
        PhoneLib old = phoneLibService.get(phoneLib.getId());
        UpdateUtil.updateIfNotNull(old,phoneLib);
        phoneLibService.update(old);
        return"success";
    }
    @RequestMapping(value = "/phoneLibs/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("phoneLibs:delete")
    @PermissionName("号码库删除")
    public String deletePhoneLib(@PathVariable("id") Integer id){
        phoneLibService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/phoneLibs/{id}",method = RequestMethod.GET)
    @RequiresPermissions("phoneLibs:get")
    @PermissionName("号码库查询")
    public PhoneLib getPhoneLib(@PathVariable("id") Integer id){
        return phoneLibService.get(id);
    }
    @RequestMapping(value = "/phoneLibs",method = RequestMethod.GET)
    @RequiresPermissions("phoneLibs:list")
    @PermissionName("号码库列表")
    public List<PhoneLib> getPhoneLibs(){
        return phoneLibService.getAll();
    }
}
