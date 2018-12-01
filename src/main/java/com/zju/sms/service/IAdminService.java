package com.zju.sms.service;

import com.zju.sms.domain.Admin;

import java.util.List;

public interface IAdminService {
    void save(Admin admin);
    void delete(String adminId);
    void update(Admin admin);
    Admin get(String adminId);
    List<Admin> getAll();
    Admin getByUsername(String username);
}
