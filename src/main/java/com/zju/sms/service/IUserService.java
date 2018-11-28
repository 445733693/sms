package com.zju.sms.service;

import java.util.List;

public interface IUserService {
    void save(User user);
    void delete(String userId);
    void update(User user);
    User get(String userId);
    List<User> getAll();
}
