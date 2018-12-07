package com.zju.sms.controller;

import com.zju.sms.domain.Blacklist;
import com.zju.sms.service.IBlacklistService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlacklistController {
    @Autowired
    private IBlacklistService blacklistService;

    @RequestMapping(value = "/blacklists",method = RequestMethod.POST)
    @RequiresPermissions("blacklists:save")
    @PermissionName("黑名单添加")
    public String saveBlacklist(@RequestBody Blacklist blacklist){
        blacklistService.save(blacklist);
        return"success";
    }
    @RequestMapping(value = "/blacklists",method = RequestMethod.PUT)
    @RequiresPermissions("blacklists:edit")
    @PermissionName("黑名单修改")
    public String updateBlacklist(@RequestBody Blacklist blacklist){
        Blacklist old = blacklistService.get(blacklist.getId());
        UpdateUtil.updateIfNotNull(old,blacklist);
        blacklistService.update(old);
        return"success";
    }
    @RequestMapping(value = "/blacklists/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("blacklists:delete")
    @PermissionName("黑名单删除")
    public String deleteBlacklist(@PathVariable("id") Integer id){
        blacklistService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/blacklists/{id}",method = RequestMethod.GET)
    @RequiresPermissions("blacklists:get")
    @PermissionName("黑名单查询")
    public Blacklist getBlacklist(@PathVariable("id") Integer id){
        return blacklistService.get(id);
    }

    @RequestMapping(value = "/blacklists",method = RequestMethod.GET)
    @RequiresPermissions("blacklists:list")
    @PermissionName("黑名单列表")
    public List<Blacklist> getAdvice(){
        return blacklistService.getAll();
    }
}
