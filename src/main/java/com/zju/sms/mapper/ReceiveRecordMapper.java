package com.zju.sms.mapper;

import com.zju.sms.domain.ReceiveRecord;
import java.util.List;

public interface ReceiveRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveRecord record);

    ReceiveRecord selectByPrimaryKey(Integer id);

    List<ReceiveRecord> selectAll();

    int updateByPrimaryKey(ReceiveRecord record);
}