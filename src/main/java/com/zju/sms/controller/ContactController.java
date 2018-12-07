package com.zju.sms.controller;

import com.zju.sms.domain.Contact;
import com.zju.sms.service.IContactService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiresPermissions("contacts")
@PermissionName("联系人")
public class ContactController {
    @Autowired
    private IContactService contactService;

    @RequestMapping(value = "/contacts",method = RequestMethod.POST)
    public String saveContact(@RequestBody Contact contact){
        contactService.save(contact);
        return"success";
    }
    @RequestMapping(value = "/contacts",method = RequestMethod.PUT)
    public String updateContact(@RequestBody Contact contact){
        Contact old = contactService.get(contact.getId());
        UpdateUtil.updateIfNotNull(old,contact);
        contactService.update(old);
        return"success";
    }
    @RequestMapping(value = "/contacts/{id}",method = RequestMethod.DELETE)
    public String deleteContact(@PathVariable("id") Integer id){
        contactService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/contacts/{id}",method = RequestMethod.GET)
    public Contact getContact(@PathVariable("id") Integer id){
        return contactService.get(id);
    }
    @RequestMapping(value = "/contacts",method = RequestMethod.GET)
    public List<Contact> getContact(){
        return contactService.getAll();
    }
}
