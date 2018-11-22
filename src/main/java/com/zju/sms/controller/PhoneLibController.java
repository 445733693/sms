package com.zju.sms.controller;

import com.zju.sms.domain.PhoneLibCategory;
import com.zju.sms.service.IPhoneLibCategoryService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneLibController{
    @Autowired
    private IPhoneLibCategoryService phoneLibCategoryService;

    @RequestMapping(value = "/phoneLibCategorys",method = RequestMethod.POST)
    public String save(@RequestBody  PhoneLibCategory phoneLibCategory){
        phoneLibCategoryService.save(phoneLibCategory);
        return"success";
    }

    @RequestMapping(value = "/phoneLibCategorys",method = RequestMethod.PUT)
    public String update(@RequestBody  PhoneLibCategory phoneLibCategory){
        PhoneLibCategory old = phoneLibCategoryService.get(phoneLibCategory.getId());
        UpdateUtil.updateIfNotNull(old,phoneLibCategory);
        phoneLibCategoryService.update(old);
        return"success";
    }
    @RequestMapping(value = "/phoneLibCategorys/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        phoneLibCategoryService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/phoneLibCategorys/{id}",method = RequestMethod.GET)
    public PhoneLibCategory get(@PathVariable("id") Integer id){
        return phoneLibCategoryService.get(id);
    }

    @RequestMapping(value = "/phoneLibCategorys",method = RequestMethod.GET)
    public List<PhoneLibCategory> get(){
        return phoneLibCategoryService.getAll();
    }
}
