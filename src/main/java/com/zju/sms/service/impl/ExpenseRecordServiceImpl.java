package com.zju.sms.service.impl;

import com.zju.sms.mapper.ExpenseRecordMapper;
import com.zju.sms.service.IExpenseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ExpenseRecordServiceImpl implements IExpenseRecordService {
    @Autowired
    private ExpenseRecordMapper expenseRecordMapper;

    @Override
    public void save(ExpenseRecord expenseRecord) {
        expenseRecord.setDate(new Date());
        expenseRecordMapper.insert(expenseRecord);
    }

    @Override
    public void delete(Integer id) {
        expenseRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ExpenseRecord expenseRecord) {
        expenseRecordMapper.updateByPrimaryKey(expenseRecord);
    }

    @Override
    public ExpenseRecord get(Integer id) {
        return expenseRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExpenseRecord> getAll() {
        return expenseRecordMapper.selectAll();
    }
}
