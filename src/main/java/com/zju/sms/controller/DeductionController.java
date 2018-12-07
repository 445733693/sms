package com.zju.sms.controller;

import com.zju.sms.domain.Deduction;
import com.zju.sms.service.IDeductionService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeductionController {
    @Autowired
    private IDeductionService deductionService;

    @RequestMapping(value = "/deductions",method = RequestMethod.POST)
    @RequiresPermissions("contacts:save")
    @PermissionName("扣量添加")
    public String saveDeduction(@RequestBody Deduction deduction){
        deductionService.save(deduction);
        return"success";
    }
    @RequestMapping(value = "/deductions",method = RequestMethod.PUT)
    @RequiresPermissions("contacts:edit")
    @PermissionName("扣量修改")
    public String updateDeduction(@RequestBody Deduction deduction){
        Deduction old = deductionService.get(deduction.getId());
        UpdateUtil.updateIfNotNull(old,deduction);
        deductionService.update(old);
        return"success";
    }
    @RequestMapping(value = "/deductions/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("contacts:delete")
    @PermissionName("扣量删除")
    public String deleteDeduction(@PathVariable("id") Integer id){
        deductionService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/deductions/{id}",method = RequestMethod.GET)
    @RequiresPermissions("contacts:get")
    @PermissionName("扣量查询")
    public Deduction getDeduction(@PathVariable("id") Integer id){
        return deductionService.get(id);
    }
    @RequestMapping(value = "/deductions",method = RequestMethod.GET)
    @RequiresPermissions("contacts:list")
    @PermissionName("扣量列表")
    public List<Deduction> getDeduction(){
        return deductionService.getAll();
    }
}
