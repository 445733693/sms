package com.zju.sms.controller;

import com.zju.sms.service.IMessageTemplateService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageTemplateController {
    @Autowired
    private IMessageTemplateService messageTemplateService;

    @RequestMapping(value = "/messageTemplates",method = RequestMethod.POST)
    public String saveMessageTemplate(@RequestBody MessageTemplate messageTemplate){
        messageTemplateService.save(messageTemplate);
        return"success";
    }
    @RequestMapping(value = "/messageTemplates",method = RequestMethod.PUT)
    public String updateMessageTemplate(@RequestBody MessageTemplate messageTemplate){
        MessageTemplate old = messageTemplateService.get(messageTemplate.getId());
        UpdateUtil.updateIfNotNull(old,messageTemplate);
        messageTemplateService.update(old);
        return"success";
    }
    @RequestMapping(value = "/messageTemplates/{id}",method = RequestMethod.DELETE)
    public String deleteMessageTemplate(@PathVariable("id") Integer id){
        messageTemplateService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/messageTemplates/{id}",method = RequestMethod.GET)
    public MessageTemplate getMessageTemplate(@PathVariable("id") Integer id){
        return messageTemplateService.get(id);
    }
    @RequestMapping(value = "/messageTemplates",method = RequestMethod.GET)
    public List<MessageTemplate> getAdvice(){
        return messageTemplateService.getAll();
    }
}
