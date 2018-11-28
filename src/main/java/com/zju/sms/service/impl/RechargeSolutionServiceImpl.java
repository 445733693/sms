package com.zju.sms.service.impl;

import com.zju.sms.mapper.RechargeSolutionMapper;
import com.zju.sms.service.IRechargeSolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RechargeSolutionServiceImpl implements IRechargeSolutionService {
    @Autowired
    private RechargeSolutionMapper rechargeSolutionMapper;

    @Override
    public void save(RechargeSolution rechargeSolution) {
        rechargeSolution.setDate(new Date());
        rechargeSolutionMapper.insert(rechargeSolution);
    }

    @Override
    public void delete(Integer id) {
        rechargeSolutionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(RechargeSolution rechargeSolution) {
        rechargeSolutionMapper.updateByPrimaryKey(rechargeSolution);
    }

    @Override
    public RechargeSolution get(Integer id) {
        return rechargeSolutionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RechargeSolution> getAll() {
        return rechargeSolutionMapper.selectAll();
    }
}
