package com.zju.sms.mapper;

import com.zju.sms.domain.AgentRechargeRecord;
import java.util.List;

public interface AgentRechargeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AgentRechargeRecord record);

    AgentRechargeRecord selectByPrimaryKey(Integer id);

    List<AgentRechargeRecord> selectAll();

    int updateByPrimaryKey(AgentRechargeRecord record);
}