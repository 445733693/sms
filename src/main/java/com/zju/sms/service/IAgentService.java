package com.zju.sms.service;

import java.util.List;

public interface IAgentService {
    void save(Agent agent);
    void delete(String agentId);
    void update(Agent agent);
    Agent get(String agentId);
    List<Agent> getAll();
}
