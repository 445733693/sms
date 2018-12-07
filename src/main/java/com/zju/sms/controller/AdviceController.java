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
@RequiresPermissions("advices")
@PermissionName("建议")
public class AdviceController {
    @Autowired
    private IAdviceService adviceService;

    @RequestMapping(value = "/advices",method = RequestMethod.POST)
    public String saveAdvice(@RequestBody Advice advice){
        adviceService.save(advice);
        return"success";
    }
    @RequestMapping(value = "/advices",method = RequestMethod.PUT)
    public String updateAdvice(@RequestBody Advice advice){
        Advice old = adviceService.get(advice.getId());
        UpdateUtil.updateIfNotNull(old,advice);
        adviceService.update(old);
        return"success";
    }
    @RequestMapping(value = "/advices/{id}",method = RequestMethod.DELETE)
    public String deleteAdvice(@PathVariable("id") Integer id){
        adviceService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/advices/{id}",method = RequestMethod.GET)
    public Advice getAdvice(@PathVariable("id") Integer id){
        return adviceService.get(id);
    }
    @RequestMapping(value = "/advices",method = RequestMethod.GET)
    public List<Advice> getAdvice(){
        return adviceService.getAll();
    }
}
