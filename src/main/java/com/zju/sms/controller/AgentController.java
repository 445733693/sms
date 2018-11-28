package com.zju.sms.controller;

import com.zju.sms.service.IAgentService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController {
    @Autowired
    private IAgentService agentService;

    @RequestMapping(value = "/agents",method = RequestMethod.POST)
    public String saveAgent(@RequestBody Agent agent){
        agentService.save(agent);
        return"success";
    }
    @RequestMapping(value = "/agents",method = RequestMethod.PUT)
    public String updateAgent(@RequestBody Agent agent){
        Agent old = agentService.get(agent.getAgentId());
        UpdateUtil.updateIfNotNull(old,agent);
        agentService.update(old);
        return"success";
    }
    @RequestMapping(value = "/agents/{id}",method = RequestMethod.DELETE)
    public String deleteAgent(@PathVariable("id") String agentId){
        agentService.delete(agentId);
        return"success";
    }
    @RequestMapping(value = "/agents/{id}",method = RequestMethod.GET)
    public Agent getAgent(@PathVariable("id") String agentId){
        return agentService.get(agentId);
    }
    @RequestMapping(value = "/agents",method = RequestMethod.GET)
    public List<Agent> getAgent(){
        return agentService.getAll();
    }
}
