package com.zju.sms.mapper;

import com.zju.sms.domain.UserRechargeRecord;
import java.util.List;

public interface UserRechargeRecordMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserRechargeRecord record);

    UserRechargeRecord selectByPrimaryKey(String userId);

    List<UserRechargeRecord> selectAll();

    int updateByPrimaryKey(UserRechargeRecord record);
}