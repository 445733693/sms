package com.zju.sms.service.impl;

import com.zju.sms.mapper.UserRechargeRecordMapper;
import com.zju.sms.service.IUserRechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserRechargeRecordServiceImpl implements IUserRechargeRecordService {
    @Autowired
    private UserRechargeRecordMapper userRechargeRecordMapper;
    @Override
    public void save(UserRechargeRecord userRechargeRecord) {
        userRechargeRecord.setDate(new Date());
        userRechargeRecordMapper.insert(userRechargeRecord);
    }

    @Override
    public void delete(Integer id) {
        userRechargeRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(UserRechargeRecord userRechargeRecord) {
        userRechargeRecordMapper.updateByPrimaryKey(userRechargeRecord);
    }

    @Override
    public UserRechargeRecord get(Integer id) {
        return userRechargeRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserRechargeRecord> getAll() {
        return userRechargeRecordMapper.selectAll();
    }
}
