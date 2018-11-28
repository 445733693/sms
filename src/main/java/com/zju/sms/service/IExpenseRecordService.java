package com.zju.sms.service;

import com.zju.sms.domain.ExpenseRecord;

import java.util.List;

public interface IExpenseRecordService {
    void save(ExpenseRecord expenseRecord);
    void delete(Integer id);
    void update(ExpenseRecord expenseRecord);
    ExpenseRecord get(Integer id);
    List<ExpenseRecord> getAll();
}
