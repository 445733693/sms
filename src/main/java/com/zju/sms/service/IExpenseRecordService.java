package com.zju.sms.service;

import java.util.List;

public interface IExpenseRecordService {
    void save(ExpenseRecord expenseRecord);
    void delete(Integer id);
    void update(ExpenseRecord expenseRecord);
    ExpenseRecord get(Integer id);
    List<ExpenseRecord> getAll();
}
