package com.zju.sms.service.impl;

import com.zju.sms.domain.Deduction;
import com.zju.sms.mapper.DeductionMapper;
import com.zju.sms.service.IDeductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeductionServiceImpl implements IDeductionService {
    @Autowired
    private DeductionMapper deductionMapper;

    @Override
    public void save(Deduction deduction) {
        deduction.setDate(new Date());
        deductionMapper.insert(deduction);
    }

    @Override
    public void delete(Integer id) {
        deductionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Deduction deduction) {
        deductionMapper.updateByPrimaryKey(deduction);
    }

    @Override
    public Deduction get(Integer id) {
        return deductionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Deduction> getAll() {
        return deductionMapper.selectAll();
    }
}
