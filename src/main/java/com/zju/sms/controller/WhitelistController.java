package com.zju.sms.controller;

import com.zju.sms.domain.Whitelist;
import com.zju.sms.service.IWhitelistService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhitelistController {
    @Autowired
    private IWhitelistService whitelistService;

    @RequestMapping(value = "/whitelists",method = RequestMethod.POST)
    @RequiresPermissions("whitelists:save")
    @PermissionName("白名单添加")
    public String saveWhitelist(@RequestBody Whitelist whitelist){
        whitelistService.save(whitelist);
        return"success";
    }
    @RequestMapping(value = "/whitelists",method = RequestMethod.PUT)
    @RequiresPermissions("whitelists:edit")
    @PermissionName("白名单修改")
    public String updateWhitelist(@RequestBody Whitelist whitelist){
        Whitelist old = whitelistService.get(whitelist.getId());
        UpdateUtil.updateIfNotNull(old,whitelist);
        whitelistService.update(old);
        return"success";
    }
    @RequestMapping(value = "/whitelists/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("whitelists:delete")
    @PermissionName("白名单删除")
    public String deleteWhitelist(@PathVariable("id") Integer id){
        whitelistService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/whitelists/{id}",method = RequestMethod.GET)
    @RequiresPermissions("whitelists:get")
    @PermissionName("白名单查询")
    public Whitelist getAdvice(@PathVariable("id") Integer id){
        return whitelistService.get(id);
    }
    @RequestMapping(value = "/whitelists",method = RequestMethod.GET)
    @RequiresPermissions("whitelists:list")
    @PermissionName("白名单列表")
    public List<Whitelist> getAdvice(){
        return whitelistService.getAll();
    }
}
