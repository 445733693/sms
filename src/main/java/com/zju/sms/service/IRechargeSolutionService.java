package com.zju.sms.service;

import com.zju.sms.domain.RechargeSolution;

import java.util.List;

public interface IRechargeSolutionService {
    void save(RechargeSolution rechargeSolution);
    void delete(Integer id);
    void update(RechargeSolution rechargeSolution);
    RechargeSolution get(Integer id);
    List<RechargeSolution> getAll();
}
