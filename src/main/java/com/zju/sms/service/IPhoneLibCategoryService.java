package com.zju.sms.service;

import com.zju.sms.domain.PhoneLibCategory;

import java.util.List;

public interface IPhoneLibCategoryService {
    void save(PhoneLibCategory phoneLibCategory);
    void delete(Integer id);
    void update(PhoneLibCategory phoneLibCategory);
    PhoneLibCategory get(Integer id);
    List<PhoneLibCategory> getAll();
}
