package com.zju.sms.controller;

import com.zju.sms.domain.AgentRechargeRecord;
import com.zju.sms.service.IAgentRechargeRecordService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentRechargeRecordController {
    @Autowired
    private IAgentRechargeRecordService agentRechargeRecordService;

    @RequestMapping(value = "/agentRechargeRecords",method = RequestMethod.POST)
    public String saveAgentRechargeRecord(@RequestBody AgentRechargeRecord agentRechargeRecord){
        agentRechargeRecordService.save(agentRechargeRecord);
        return"success";
    }
    @RequestMapping(value = "/agentRechargeRecords",method = RequestMethod.PUT)
    public String updateAgentRechargeRecord(@RequestBody AgentRechargeRecord agentRechargeRecord){
        AgentRechargeRecord old = agentRechargeRecordService.get(agentRechargeRecord.getId());
        UpdateUtil.updateIfNotNull(old,agentRechargeRecord);
        agentRechargeRecordService.update(old);
        return"success";
    }
    @RequestMapping(value = "/agentRechargeRecords/{id}",method = RequestMethod.DELETE)
    public String deleteAgentRechargeRecord(@PathVariable("id") Integer id){
        agentRechargeRecordService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/agentRechargeRecords/{id}",method = RequestMethod.GET)
    public AgentRechargeRecord getAgentRechargeRecord(@PathVariable("id") Integer id){
        return agentRechargeRecordService.get(id);
    }
    @RequestMapping(value = "/agentRechargeRecords",method = RequestMethod.GET)
    public List<AgentRechargeRecord> getAgentRechargeRecord(){
        return agentRechargeRecordService.getAll();
    }
}

