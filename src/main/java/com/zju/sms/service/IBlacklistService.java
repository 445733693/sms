package com.zju.sms.service;

import com.zju.sms.domain.Blacklist;

import java.util.List;

public interface IBlacklistService {
    void save(Blacklist blacklist);
    void delete(Integer id);
    void update(Blacklist blacklist);
    Blacklist get(Integer id);
    List<Blacklist> getAll();
}
