package com.zju.sms.controller;

import com.zju.sms.service.IMessageDraftService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageDraftController {
    @Autowired
    private IMessageDraftService messageDraftService;

    @RequestMapping(value = "/messageDrafts",method = RequestMethod.POST)
    public String saveMessageDraft(@RequestBody MessageDraft messageDraft){
        messageDraftService.save(messageDraft);
        return"success";
    }
    @RequestMapping(value = "/messageDrafts",method = RequestMethod.PUT)
    public String updateMessageDraft(@RequestBody MessageDraft messageDraft){
        MessageDraft old = messageDraftService.get(messageDraft.getId());
        UpdateUtil.updateIfNotNull(old,messageDraft);
        messageDraftService.update(old);
        return"success";
    }
    @RequestMapping(value = "/messageDrafts/{id}",method = RequestMethod.DELETE)
    public String deleteMessageDraft(@PathVariable("id") Integer id){
        messageDraftService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/messageDrafts/{id}",method = RequestMethod.GET)
    public MessageDraft getMessageDraft(@PathVariable("id") Integer id){
        return messageDraftService.get(id);
    }
    @RequestMapping(value = "/messageDrafts",method = RequestMethod.GET)
    public List<MessageDraft> getMessageDraft(){
        return messageDraftService.getAll();
    }
}
