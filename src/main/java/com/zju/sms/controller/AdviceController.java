package com.zju.sms.controller;

import com.zju.sms.domain.Advice;
import com.zju.sms.service.IAdviceService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdviceController {
    @Autowired
    private IAdviceService adviceService;

    @RequestMapping(value = "/advices",method = RequestMethod.POST)
    @RequiresPermissions("advices:save")
    @PermissionName("用户建议添加")
    public String saveAdvice(@RequestBody Advice advice){
        adviceService.save(advice);
        return"success";
    }
    @RequestMapping(value = "/advices",method = RequestMethod.PUT)
/*    @RequiresPermissions("advices:edit")
    @PermissionName("用户建议修改")*/
    public String updateAdvice(@RequestBody Advice advice){
        Advice old = adviceService.get(advice.getId());
        UpdateUtil.updateIfNotNull(old,advice);
        adviceService.update(old);
        return"success";
    }
    @RequestMapping(value = "/advices/{id}",method = RequestMethod.DELETE)
/*    @RequiresPermissions("advices:delete")
    @PermissionName("用户建议删除")*/
    public String deleteAdvice(@PathVariable("id") Integer id){
        adviceService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/advices/{id}",method = RequestMethod.GET)
/*    @RequiresPermissions("advices:get")
    @PermissionName("用户建议查询")*/
    public Advice getAdvice(@PathVariable("id") Integer id){
        return adviceService.get(id);
    }

    @RequestMapping(value = "/advices",method = RequestMethod.GET)
    @RequiresPermissions("advices:list")
    @PermissionName("用户建议列表")
    public List<Advice> getAdvice(){
        return adviceService.getAll();
    }
}
