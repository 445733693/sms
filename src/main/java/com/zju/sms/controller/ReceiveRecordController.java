package com.zju.sms.controller;

import com.zju.sms.service.IReceiveRecordService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceiveRecordController {
    @Autowired
    private IReceiveRecordService receiveRecordService;

    @RequestMapping(value = "/c",method = RequestMethod.POST)
    public String saveReceiveRecord(@RequestBody ReceiveRecord receiveRecord){
        receiveRecordService.save(receiveRecord);
        return"success";
    }
    @RequestMapping(value = "/receiveRecords",method = RequestMethod.PUT)
    public String updateReceiveRecord(@RequestBody ReceiveRecord receiveRecord){
        ReceiveRecord old = receiveRecordService.get(receiveRecord.getId());
        UpdateUtil.updateIfNotNull(old,receiveRecord);
        receiveRecordService.update(old);
        return"success";
    }
    @RequestMapping(value = "/receiveRecords/{id}",method = RequestMethod.DELETE)
    public String deleteReceiveRecord(@PathVariable("id") Integer id){
        receiveRecordService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/receiveRecords/{id}",method = RequestMethod.GET)
    public ReceiveRecord getReceiveRecord(@PathVariable("id") Integer id){
        return receiveRecordService.get(id);
    }
    @RequestMapping(value = "/receiveRecords",method = RequestMethod.GET)
    public List<ReceiveRecord> getAdvice(){
        return receiveRecordService.getAll();
    }
}
