package com.zju.sms.service;

import com.zju.sms.domain.Agent;

import java.util.List;

public interface IAgentService {
    void save(Agent agent);
    void delete(Integer id);
    void update(Agent agent);
    Agent get(Integer id);
    List<Agent> getAll();
    Agent getByUsername(String username);
}
