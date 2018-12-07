package com.zju.sms.controller;

import com.zju.sms.domain.MessageDraft;
import com.zju.sms.service.IMessageDraftService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageDraftController {
    @Autowired
    private IMessageDraftService messageDraftService;

    @RequestMapping(value = "/messageDrafts",method = RequestMethod.POST)
    @RequiresPermissions("messageDrafts:save")
    @PermissionName("草稿添加")
    public String saveMessageDraft(@RequestBody MessageDraft messageDraft){
        messageDraftService.save(messageDraft);
        return"success";
    }
    @RequestMapping(value = "/messageDrafts",method = RequestMethod.PUT)
    @RequiresPermissions("messageDrafts:edit")
    @PermissionName("草稿修改")
    public String updateMessageDraft(@RequestBody MessageDraft messageDraft){
        MessageDraft old = messageDraftService.get(messageDraft.getId());
        UpdateUtil.updateIfNotNull(old,messageDraft);
        messageDraftService.update(old);
        return"success";
    }
    @RequestMapping(value = "/messageDrafts/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("messageDrafts:delete")
    @PermissionName("草稿删除")
    public String deleteMessageDraft(@PathVariable("id") Integer id){
        messageDraftService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/messageDrafts/{id}",method = RequestMethod.GET)
    @RequiresPermissions("messageDrafts:get")
    @PermissionName("草稿查询")
    public MessageDraft getMessageDraft(@PathVariable("id") Integer id){
        return messageDraftService.get(id);
    }
    @RequestMapping(value = "/messageDrafts",method = RequestMethod.GET)
    @RequiresPermissions("messageDrafts:list")
    @PermissionName("草稿列表")
    public List<MessageDraft> getMessageDraft(){
        return messageDraftService.getAll();
    }
}
