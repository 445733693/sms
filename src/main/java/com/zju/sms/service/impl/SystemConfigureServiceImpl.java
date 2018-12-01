package com.zju.sms.service.impl;

import com.zju.sms.domain.SystemConfigure;
import com.zju.sms.mapper.SystemConfigureMapper;
import com.zju.sms.service.ISystemConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SystemConfigureServiceImpl implements ISystemConfigureService {
    @Autowired
    private SystemConfigureMapper systemConfigureMapper;

    @Override
    public void save(SystemConfigure systemConfigure) {
        systemConfigureMapper.insert(systemConfigure);
    }

    @Override
    public void delete(Integer id) {
        systemConfigureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(SystemConfigure systemConfigure) {
        systemConfigureMapper.updateByPrimaryKey(systemConfigure);
    }

    @Override
    public SystemConfigure get(Integer id) {
        return systemConfigureMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SystemConfigure> getAll() {
        return systemConfigureMapper.selectAll();
    }
}
