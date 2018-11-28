package com.zju.sms.service.impl;

import com.zju.sms.domain.Agent;
import com.zju.sms.mapper.AgentMapper;
import com.zju.sms.service.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements IAgentService {
    @Autowired
    private AgentMapper agentMapper;


    @Override
    public void save(Agent agent) {
        agentMapper.insert(agent);
    }

    @Override
    public void delete(String agentId) {
        agentMapper.deleteByPrimaryKey(agentId);
    }

    @Override
    public void update(Agent agent) {
        agentMapper.updateByPrimaryKey(agent);
    }

    @Override
    public Agent get(String agentId) {
        return agentMapper.selectByPrimaryKey(agentId);
    }

    @Override
    public List<Agent> getAll() {
        return agentMapper.selectAll();
    }
}
