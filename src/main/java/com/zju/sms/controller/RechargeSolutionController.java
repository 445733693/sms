package com.zju.sms.controller;

import com.zju.sms.domain.RechargeSolution;
import com.zju.sms.service.IRechargeSolutionService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RechargeSolutionController {
    @Autowired
    private IRechargeSolutionService rechargeSolutionService;

    @RequestMapping(value = "/rechargeSolutions",method = RequestMethod.POST)
    @RequiresPermissions("rechargeSolutions:save")
    @PermissionName("充值方案添加")
    public String saveRechargeSolution(@RequestBody RechargeSolution rechargeSolution){
        rechargeSolutionService.save(rechargeSolution);
        return"success";
    }
    @RequestMapping(value = "/rechargeSolutions",method = RequestMethod.PUT)
    @RequiresPermissions("rechargeSolutions:edit")
    @PermissionName("充值方案修改")
    public String updateRechargeSolution(@RequestBody RechargeSolution rechargeSolution){
        RechargeSolution old = rechargeSolutionService.get(rechargeSolution.getId());
        UpdateUtil.updateIfNotNull(old,rechargeSolution);
        rechargeSolutionService.update(old);
        return"success";
    }
    @RequestMapping(value = "/rechargeSolutions/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("rechargeSolutions:delete")
    @PermissionName("充值方案删除")
    public String deleteRechargeSolution(@PathVariable("id") Integer id){
        rechargeSolutionService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/rechargeSolutions/{id}",method = RequestMethod.GET)
    @RequiresPermissions("rechargeSolutions:get")
    @PermissionName("充值方案查询")
    public RechargeSolution getRechargeSolution(@PathVariable("id") Integer id){
        return rechargeSolutionService.get(id);
    }
    @RequestMapping(value = "/rechargeSolutions",method = RequestMethod.GET)
    @RequiresPermissions("rechargeSolutions:list")
    @PermissionName("充值方案列表")
    public List<RechargeSolution> getAdvice(){
        return rechargeSolutionService.getAll();
    }
}
