package com.zju.sms.service.impl;

import com.zju.sms.mapper.UserMapper;
import com.zju.sms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        user.setRegisterDate(new Date());
        userMapper.insert(user);
    }

    @Override
    public void delete(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User get(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }
}
