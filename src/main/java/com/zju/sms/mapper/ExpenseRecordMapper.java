package com.zju.sms.mapper;

import com.zju.sms.domain.ExpenseRecord;
import java.util.List;

public interface ExpenseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpenseRecord record);

    ExpenseRecord selectByPrimaryKey(Integer id);

    List<ExpenseRecord> selectAll();

    int updateByPrimaryKey(ExpenseRecord record);
}