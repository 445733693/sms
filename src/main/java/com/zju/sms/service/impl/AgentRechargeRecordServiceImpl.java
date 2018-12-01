package com.zju.sms.service.impl;

import com.zju.sms.domain.AgentRechargeRecord;
import com.zju.sms.mapper.AgentRechargeRecordMapper;
import com.zju.sms.service.IAgentRechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgentRechargeRecordServiceImpl implements IAgentRechargeRecordService {
    @Autowired
    private AgentRechargeRecordMapper agentRechargeRecordMapper;

    @Override
    public void save(AgentRechargeRecord agentRechargeRecord) {
        agentRechargeRecord.setDate(new Date());
        agentRechargeRecordMapper.insert(agentRechargeRecord);
    }

    @Override
    public void delete(Integer id) {
        agentRechargeRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(AgentRechargeRecord agentRechargeRecord) {
        agentRechargeRecordMapper.updateByPrimaryKey(agentRechargeRecord);
    }

    @Override
    public AgentRechargeRecord get(Integer id) {
        return agentRechargeRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AgentRechargeRecord> getAll() {
        return agentRechargeRecordMapper.selectAll();
    }
}
