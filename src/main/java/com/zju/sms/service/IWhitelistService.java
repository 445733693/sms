package com.zju.sms.service;

import com.zju.sms.domain.Whitelist;

import java.util.List;

public interface IWhitelistService {
    void save(Whitelist whitelist);
    void delete(Integer id);
    void update(Whitelist whitelist);
    Whitelist get(Integer id);
    List<Whitelist> getAll();
}
