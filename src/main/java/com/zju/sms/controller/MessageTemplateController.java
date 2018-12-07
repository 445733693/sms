package com.zju.sms.controller;

import com.zju.sms.domain.MessageTemplate;
import com.zju.sms.service.IMessageTemplateService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageTemplateController {
    @Autowired
    private IMessageTemplateService messageTemplateService;

    @RequestMapping(value = "/messageTemplates",method = RequestMethod.POST)
    @RequiresPermissions("messageTemplates:save")
    @PermissionName("短信模板添加")
    public String saveMessageTemplate(@RequestBody MessageTemplate messageTemplate){
        messageTemplateService.save(messageTemplate);
        return"success";
    }
    @RequestMapping(value = "/messageTemplates",method = RequestMethod.PUT)
    @RequiresPermissions("messageTemplates:edit")
    @PermissionName("短信模板修改")
    public String updateMessageTemplate(@RequestBody MessageTemplate messageTemplate){
        MessageTemplate old = messageTemplateService.get(messageTemplate.getId());
        UpdateUtil.updateIfNotNull(old,messageTemplate);
        messageTemplateService.update(old);
        return"success";
    }
    @RequestMapping(value = "/messageTemplates/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("messageTemplates:delete")
    @PermissionName("短信模板删除")
    public String deleteMessageTemplate(@PathVariable("id") Integer id){
        messageTemplateService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/messageTemplates/{id}",method = RequestMethod.GET)
    @RequiresPermissions("messageTemplates:get")
    @PermissionName("短信模板查询")
    public MessageTemplate getMessageTemplate(@PathVariable("id") Integer id){
        return messageTemplateService.get(id);
    }
    @RequestMapping(value = "/messageTemplates",method = RequestMethod.GET)
    @RequiresPermissions("messageTemplates:list")
    @PermissionName("短信模板列表")
    public List<MessageTemplate> getAdvice(){
        return messageTemplateService.getAll();
    }
}
