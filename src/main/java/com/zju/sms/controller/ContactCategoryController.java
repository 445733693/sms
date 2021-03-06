package com.zju.sms.controller;


import com.zju.sms.domain.ContactCategory;
import com.zju.sms.service.IContactCategoryService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(value = "/contactCategorys/{id}",method = RequestMethod.DELETE)
    public String deleteContactCategory(@PathVariable("id") Integer id){
        contactCategoryService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/contactCategorys/{id}",method = RequestMethod.GET)
    public ContactCategory getContactCategory(@PathVariable("id") Integer id){
        return contactCategoryService.get(id);
    }
    @RequestMapping(value = "/contactCategorys",method = RequestMethod.GET)
    public List<ContactCategory> getContactCategory(){
        return contactCategoryService.getAll();
    }
}
