package com.zju.sms.controller;

import com.zju.sms.domain.PhoneLibCategory;
import com.zju.sms.service.IPhoneLibCategoryService;
import com.zju.sms.service.impl.PhoneLibCategoryServiceImpl;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "" ,tags = "号码库分类接口")
public class PhoneLibCategoryController {
    @Autowired
    private IPhoneLibCategoryService phoneLibCategoryService;

    @RequestMapping(value = "/phoneLibCategorys",method = RequestMethod.POST)
    @ApiOperation(value = "添加号码库分类" ,notes = "增加一条号码库记录",httpMethod = "POST")
    @RequiresPermissions("phoneLibCategorys:save")
    @PermissionName("号码库分类添加")
    public String saveCategory(@RequestBody PhoneLibCategory phoneLibCategory){
        phoneLibCategoryService.save(phoneLibCategory);
        return"success";
    }
    @RequestMapping(value = "/phoneLibCategorys",method = RequestMethod.PUT)
    @RequiresPermissions("phoneLibCategorys:edit")
    @PermissionName("号码库分类修改")
    public String updateCategory(@RequestBody  PhoneLibCategory phoneLibCategory){
        PhoneLibCategory old = phoneLibCategoryService.get(phoneLibCategory.getId());
        UpdateUtil.updateIfNotNull(old,phoneLibCategory);
        phoneLibCategoryService.update(old);
        return"success";
    }
    @RequestMapping(value = "/phoneLibCategorys/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("phoneLibCategorys:delete")
    @PermissionName("号码库分类删除")
    public String deleteCategory(@PathVariable("id") Integer id){
        phoneLibCategoryService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/phoneLibCategorys/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询号码库分类",notes = "需要输入一个id号来查询号码库分类信息",httpMethod = "GET")
    @RequiresPermissions("phoneLibCategorys:get")
    @PermissionName("号码库分类查询")
    public PhoneLibCategory getCategory(@PathVariable("id") Integer id){
        return phoneLibCategoryService.get(id);
    }

    @RequestMapping(value = "/phoneLibCategorys",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有号码库分类",notes = "不用任何参数，列出所有号码库分类",httpMethod = "GET")
    @RequiresPermissions("phoneLibCategorys:list")
    @PermissionName("号码库分类列表")
    public List<PhoneLibCategory> getCategory(){
        return phoneLibCategoryService.getAll();
    }

}

