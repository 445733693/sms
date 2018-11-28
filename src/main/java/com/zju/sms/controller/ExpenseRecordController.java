package com.zju.sms.controller;

import com.zju.sms.service.IExpenseRecordService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseRecordController {
    @Autowired
    private IExpenseRecordService expenseRecordService;

    @RequestMapping(value = "/expenseRecords",method = RequestMethod.POST)
    public String saveExpenseRecord(@RequestBody ExpenseRecord expenseRecord){
        expenseRecordService.save(expenseRecord);
        return"success";
    }
    @RequestMapping(value = "/expenseRecords",method = RequestMethod.PUT)
    public String updateExpenseRecord(@RequestBody ExpenseRecord expenseRecord){
        ExpenseRecord old = expenseRecordService.get(expenseRecord.getId());
        UpdateUtil.updateIfNotNull(old,expenseRecord);
        expenseRecordService.update(old);
        return"success";
    }
    @RequestMapping(value = "/expenseRecords/{id}",method = RequestMethod.DELETE)
    public String deleteExpenseRecord(@PathVariable("id") Integer id){
        expenseRecordService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/expenseRecords/{id}",method = RequestMethod.GET)
    public ExpenseRecord getAdvice(@PathVariable("id") Integer id){
        return expenseRecordService.get(id);
    }
    @RequestMapping(value = "/expenseRecords",method = RequestMethod.GET)
    public List<ExpenseRecord> getAdvice(){
        return expenseRecordService.getAll();
    }
}
