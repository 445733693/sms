package com.zju.sms.service.impl;

import com.zju.sms.domain.PhoneLibCategory;
import com.zju.sms.mapper.PhoneLibCategoryMapper;
import com.zju.sms.service.IPhoneLibCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneLibCategoryServiceImpl implements IPhoneLibCategoryService {
    @Autowired
    private PhoneLibCategoryMapper phoneLibCategoryMapper;

    @Override
    public void save(PhoneLibCategory phoneLibCategory) {
        phoneLibCategoryMapper.insert(phoneLibCategory);
    }

    @Override
    public void delete(Integer id) {
        phoneLibCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(PhoneLibCategory phoneLibCategory) {
        phoneLibCategoryMapper.updateByPrimaryKey(phoneLibCategory);
    }

    @Override
    public PhoneLibCategory get(Integer id) {
        return phoneLibCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PhoneLibCategory> getAll() {
        return phoneLibCategoryMapper.selectAll();
    }
}
