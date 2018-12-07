package com.zju.sms.controller;

import com.zju.sms.domain.TemplateCategory;
import com.zju.sms.service.ITemplateCategoryService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemplateCategoryController {
    @Autowired
    private ITemplateCategoryService templateCategoryService;

    @RequestMapping(value = "/templateCategorys",method = RequestMethod.POST)
    @RequiresPermissions("templateCategorys:save")
    @PermissionName("短信模板分类添加")
    public String saveTemplateCategory(@RequestBody TemplateCategory templateCategory){
        templateCategoryService.save(templateCategory);
        return"success";
    }
    @RequestMapping(value = "/templateCategorys",method = RequestMethod.PUT)
    @RequiresPermissions("templateCategorys:edit")
    @PermissionName("短信模板分类修改")
    public String updateTemplateCategory(@RequestBody TemplateCategory templateCategory){
        TemplateCategory old = templateCategoryService.get(templateCategory.getId());
        UpdateUtil.updateIfNotNull(old,templateCategory);
        templateCategoryService.update(old);
        return"success";
    }
    @RequestMapping(value = "/templateCategorys/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("templateCategorys:delete")
    @PermissionName("短信模板分类删除")
    public String deleteTemplateCategory(@PathVariable("id") Integer id){
        templateCategoryService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/templateCategorys/{id}",method = RequestMethod.GET)
    @RequiresPermissions("templateCategorys:get")
    @PermissionName("短信模板分类查询")
    public TemplateCategory getTemplateCategory(@PathVariable("id") Integer id){
        return templateCategoryService.get(id);
    }
    @RequestMapping(value = "/templateCategorys",method = RequestMethod.GET)
    @RequiresPermissions("templateCategorys:list")
    @PermissionName("短信模板分类列表")
    public List<TemplateCategory> getAdvice(){
        return templateCategoryService.getAll();
    }
}
