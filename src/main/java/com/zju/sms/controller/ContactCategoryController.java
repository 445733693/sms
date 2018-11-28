package com.zju.sms.controller;


import com.zju.sms.service.IContactCategoryService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactCategoryController {
    @Autowired
    private IContactCategoryService contactCategoryService;

    @RequestMapping(value = "/contactCategorys",method = RequestMethod.POST)
    public String saveContactCategory(@RequestBody ContactCategory contactCategory){
        contactCategoryService.save(contactCategory);
        return"success";
    }
    @RequestMapping(value = "/contactCategorys",method = RequestMethod.PUT)
    public String updateContactCategory(@RequestBody ContactCategory contactCategory){
        ContactCategory old = contactCategoryService.get(contactCategory.getUserId());
        UpdateUtil.updateIfNotNull(old,contactCategory);
        contactCategoryService.update(old);
        return"success";
    }

}
