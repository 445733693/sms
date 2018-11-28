package com.zju.sms.service;

import java.util.List;

public interface IUserRechargeRecordService {
    void save(UserRechargeRecord userRechargeRecord);
    void delete(Integer id);
    void update(UserRechargeRecord userRechargeRecord);
    UserRechargeRecord get(Integer id);
    List<UserRechargeRecord> getAll();
}
