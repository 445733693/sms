package com.zju.sms.mapper;

import com.zju.sms.domain.Agent;
import java.util.List;

public interface AgentMapper {
    int deleteByPrimaryKey(String agentId);

    int insert(Agent record);

    Agent selectByPrimaryKey(String agentId);

    List<Agent> selectAll();

    int updateByPrimaryKey(Agent record);
}