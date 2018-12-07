package com.zju.sms.controller;


import com.zju.sms.domain.ContactCategory;
import com.zju.sms.service.IContactCategoryService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactCategoryController {
    @Autowired
    private IContactCategoryService contactCategoryService;

    @RequestMapping(value = "/contactCategorys",method = RequestMethod.POST)
    @RequiresPermissions("contactCategorys:save")
    @PermissionName("联系人分类添加")
    public String saveContactCategory(@RequestBody ContactCategory contactCategory){
        contactCategoryService.save(contactCategory);
        return"success";
    }
    @RequestMapping(value = "/contactCategorys",method = RequestMethod.PUT)
    @RequiresPermissions("contactCategorys:edit")
    @PermissionName("联系人分类修改")
    public String updateContactCategory(@RequestBody ContactCategory contactCategory){
        ContactCategory old = contactCategoryService.get(contactCategory.getUserId());
        UpdateUtil.updateIfNotNull(old,contactCategory);
        contactCategoryService.update(old);
        return"success";
    }
    @RequestMapping(value = "/contactCategorys/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("contactCategorys:delete")
    @PermissionName("联系人分类删除")
    public String deleteContactCategory(@PathVariable("id") Integer id){
        contactCategoryService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/contactCategorys/{id}",method = RequestMethod.GET)
    @RequiresPermissions("contactCategorys:get")
    @PermissionName("联系人分类查询")
    public ContactCategory getContactCategory(@PathVariable("id") Integer id){
        return contactCategoryService.get(id);
    }
    @RequestMapping(value = "/contactCategorys",method = RequestMethod.GET)
    @RequiresPermissions("contactCategorys:list")
    @PermissionName("联系人分类列表")
    public List<ContactCategory> getContactCategory(){
        return contactCategoryService.getAll();
    }
}
