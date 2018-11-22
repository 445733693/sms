package com.zju.sms.controller;

import com.zju.sms.domain.TemplateCategory;
import com.zju.sms.service.ITemplateCategoryService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemplateCategoryController {
    @Autowired
    private ITemplateCategoryService templateCategoryService;

    @RequestMapping(value = "/templateCategorys",method = RequestMethod.POST)
    public String save(@RequestBody TemplateCategory templateCategory){
        templateCategoryService.save(templateCategory);
        return "success";
    }
    @RequestMapping(value = "/templateCategorys",method = RequestMethod.PUT)
    public String update(@RequestBody TemplateCategory templateCategory){
        TemplateCategory old = templateCategoryService.get(templateCategory.getId());
        UpdateUtil.updateIfNotNull(old,templateCategory);
        templateCategoryService.update(old);
        return"success";
    }


    @RequestMapping(value = "/templateCategorys/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id){
        templateCategoryService.delete(id);
        return "success";
    }


    @RequestMapping(value = "/templateCategorys/{id}",method = RequestMethod.GET)
    public TemplateCategory get(@PathVariable Integer id){
        return templateCategoryService.get(id);
    }

    @RequestMapping(value = "/templateCategorys",method = RequestMethod.GET)
    public List<TemplateCategory> get(){
        return templateCategoryService.getAll();
    }
}
