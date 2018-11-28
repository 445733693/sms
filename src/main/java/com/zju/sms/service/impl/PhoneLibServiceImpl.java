package com.zju.sms.service.impl;

import com.zju.sms.mapper.PhoneLibMapper;
import com.zju.sms.service.IPhoneLibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneLibServiceImpl implements IPhoneLibService {
    @Autowired
    private PhoneLibMapper phoneLibMapper;

    @Override
    public void save(PhoneLib phoneLib) {
        String phone = phoneLib.getPhone();
        String[] split = phone.split(",");
        phoneLib.setNumber(split.length);
        phoneLibMapper.insert(phoneLib);
    }

    @Override
    public void delete(Integer id) {
        phoneLibMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(PhoneLib phoneLib) {
        phoneLibMapper.updateByPrimaryKey(phoneLib);
    }

    @Override
    public PhoneLib get(Integer id) {
        return phoneLibMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PhoneLib> getAll() {
        return phoneLibMapper.selectAll();
    }
}
