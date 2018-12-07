package com.zju.sms.controller;

import com.zju.sms.domain.SendRecord;
import com.zju.sms.service.ISendRecordService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SendRecordController {
    @Autowired
    private ISendRecordService sendRecordService;

    @RequestMapping(value = "/sendRecords",method = RequestMethod.POST)
    public String saveSendRecord(@RequestBody SendRecord sendRecord){
        sendRecordService.save(sendRecord);
        return"success";
    }
    @RequestMapping(value = "/sendRecords",method = RequestMethod.PUT)
    public String updateSendRecord(@RequestBody SendRecord sendRecord){
        SendRecord old = sendRecordService.get(sendRecord.getId());
        UpdateUtil.updateIfNotNull(old,sendRecord);
        sendRecordService.update(old);
        return"success";
    }
    @RequestMapping(value = "/sendRecords/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("sendRecords:delete")
    @PermissionName("发送记录删除")
    public String deleteSendRecord(@PathVariable("id") Integer id){
        sendRecordService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/sendRecords/{id}",method = RequestMethod.GET)
    @RequiresPermissions("sendRecords:get")
    @PermissionName("发送记录查询")
    public SendRecord getSendRecord(@PathVariable("id") Integer id){
        return sendRecordService.get(id);
    }
    @RequestMapping(value = "/sendRecords",method = RequestMethod.GET)
    @RequiresPermissions("sendRecords:list")
    @PermissionName("发送记录列表")
    public List<SendRecord> getSendRecord(){
        return sendRecordService.getAll();
    }
}
