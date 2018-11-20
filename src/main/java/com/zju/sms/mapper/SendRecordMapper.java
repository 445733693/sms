package com.zju.sms.mapper;

import com.zju.sms.domain.SendRecord;
import java.util.List;

public interface SendRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SendRecord record);

    SendRecord selectByPrimaryKey(Integer id);

    List<SendRecord> selectAll();

    int updateByPrimaryKey(SendRecord record);
}