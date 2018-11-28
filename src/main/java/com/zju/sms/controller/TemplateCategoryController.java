package com.zju.sms.controller;

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
    public String saveTemplateCategory(@RequestBody TemplateCategory templateCategory){
        templateCategoryService.save(templateCategory);
        return"success";
    }
    @RequestMapping(value = "/templateCategorys",method = RequestMethod.PUT)
    public String updateTemplateCategory(@RequestBody TemplateCategory templateCategory){
        TemplateCategory old = templateCategoryService.get(templateCategory.getId());
        UpdateUtil.updateIfNotNull(old,templateCategory);
        templateCategoryService.update(old);
        return"success";
    }
    @RequestMapping(value = "/templateCategorys/{id}",method = RequestMethod.DELETE)
    public String deleteTemplateCategory(@PathVariable("id") Integer id){
        templateCategoryService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/templateCategorys/{id}",method = RequestMethod.GET)
    public TemplateCategory getTemplateCategory(@PathVariable("id") Integer id){
        return templateCategoryService.get(id);
    }
    @RequestMapping(value = "/templateCategorys",method = RequestMethod.GET)
    public List<TemplateCategory> getAdvice(){
        return templateCategoryService.getAll();
    }
}
