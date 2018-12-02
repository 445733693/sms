package com.zju.sms.service;

import com.zju.sms.domain.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    void delete(Integer id);
    void update(User user);
    User get(Integer id);
    List<User> getAll();
    User getByUsername(String username);
}
