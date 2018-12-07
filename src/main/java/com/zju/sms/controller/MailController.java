package com.zju.sms.controller;

import com.zju.sms.domain.Mail;
import com.zju.sms.service.IMailService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MailController {
    @Autowired
    private IMailService mailService;

    @RequestMapping(value = "/mails",method = RequestMethod.POST)
    @RequiresPermissions("mails:save")
    @PermissionName("站内信添加")
    public String saveMail(@RequestBody Mail mail){
        mailService.save(mail);
        return"success";
    }
    @RequestMapping(value = "/mails",method = RequestMethod.PUT)
    @RequiresPermissions("mails:edit")
    @PermissionName("站内信修改")
    public String updateMail(@RequestBody Mail mail){
        Mail old = mailService.get(mail.getId());
        UpdateUtil.updateIfNotNull(old,mail);
        mailService.update(old);
        return"success";
    }
    @RequestMapping(value = "/mails/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("mails:delete")
    @PermissionName("站内信删除")
    public String deleteMail(@PathVariable("id") Integer id){
        mailService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/mails/{id}",method = RequestMethod.GET)
    @RequiresPermissions("mails:get")
    @PermissionName("站内信查询")
    public Mail getMail(@PathVariable("id") Integer id){
        return mailService.get(id);
    }
    @RequestMapping(value = "/mails",method = RequestMethod.GET)
    @RequiresPermissions("mails:list")
    @PermissionName("站内信列表")
    public List<Mail> getAdvice(){
        return mailService.getAll();
    }
}
