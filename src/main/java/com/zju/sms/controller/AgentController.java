package com.zju.sms.controller;

import com.zju.sms.domain.Agent;
import com.zju.sms.service.IAgentService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiresPermissions("agents")
@PermissionName("代理商账户")
public class AgentController {
    @Autowired
    private IAgentService agentService;

    @RequestMapping(value = "/agents",method = RequestMethod.POST)
    @RequiresPermissions("agents:save")
    @PermissionName("代理商账户添加")
    public String saveAgent(@RequestBody Agent agent){
        agentService.save(agent);
        return"success";
    }
    @RequestMapping(value = "/agents",method = RequestMethod.PUT)
    @RequiresPermissions("agents:edit")
    @PermissionName("代理商账户修改")
    public String updateAgent(@RequestBody Agent agent){
        Agent old = agentService.get(agent.getId());
        UpdateUtil.updateIfNotNull(old,agent);
        agentService.update(old);
        return"success";
    }
    @RequestMapping(value = "/agents/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("agents:delete")
    @PermissionName("代理商账户删除")
    public String deleteAgent(@PathVariable("id") Integer id){
        agentService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/agents/{id}",method = RequestMethod.GET)
    @RequiresPermissions("agents:get")
    @PermissionName("代理商账户查询")
    public Agent getAgent(@PathVariable("id") Integer id){
        return agentService.get(id);
    }

    @RequestMapping(value = "/agents",method = RequestMethod.GET)
    @RequiresPermissions("agents:list")
    @PermissionName("代理商账户列表")
    public List<Agent> getAgent(){
        return agentService.getAll();
    }
//    @RequestMapping(value = "/agents",method = RequestMethod.GET)
//    public Agent getAgentUser(@RequestBody String username){
//        return agentService.getByUsername(username);
//    }
}
