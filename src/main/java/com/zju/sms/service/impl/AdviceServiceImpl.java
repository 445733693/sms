package com.zju.sms.service.impl;

import com.zju.sms.domain.Advice;
import com.zju.sms.mapper.AdviceMapper;
import com.zju.sms.service.IAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdviceServiceImpl implements IAdviceService {
    @Autowired
    private AdviceMapper adviceMapper;

    @Override
    public void save(Advice advice) {
        advice.setDate(new Date());
        adviceMapper.insert(advice);
    }

    @Override
    public void delete(Integer id) {
        adviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Advice advice) {
        adviceMapper.updateByPrimaryKey(advice);
    }

    @Override
    public Advice get(Integer id) {
        return adviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Advice> getAll() {
        return adviceMapper.selectAll();
    }

}
