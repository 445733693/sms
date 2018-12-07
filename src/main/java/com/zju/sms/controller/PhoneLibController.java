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
@RequiresPermissions("phoneLibs")
@PermissionName("号码库")
public class PhoneLibController{
    @Autowired
    private IPhoneLibService phoneLibService;
    /**
     * 添加号码库
     * @param phoneLib 号码库对象
     * @return 添加成功的标志
     */
    @RequestMapping(value = "/phoneLibs",method = RequestMethod.POST)
    public String savePhoneLib(@RequestBody PhoneLib phoneLib){
        phoneLibService.save(phoneLib);
        return"success";
    }
    @RequestMapping(value = "/phoneLibs",method = RequestMethod.PUT)
    public String updatePhoneLib(@RequestBody PhoneLib phoneLib){
        PhoneLib old = phoneLibService.get(phoneLib.getId());
        UpdateUtil.updateIfNotNull(old,phoneLib);
        phoneLibService.update(old);
        return"success";
    }
    @RequestMapping(value = "/phoneLibs/{id}",method = RequestMethod.DELETE)
    public String deletePhoneLib(@PathVariable("id") Integer id){
        phoneLibService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/phoneLibs/{id}",method = RequestMethod.GET)
    public PhoneLib getPhoneLib(@PathVariable("id") Integer id){
        return phoneLibService.get(id);
    }
    @RequestMapping(value = "/phoneLibs",method = RequestMethod.GET)
    public List<PhoneLib> getPhoneLibs(){
        return phoneLibService.getAll();
    }
}
