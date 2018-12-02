package com.zju.sms.service.impl;

import com.zju.sms.domain.ContactCategory;
import com.zju.sms.mapper.ContactCategoryMapper;
import com.zju.sms.service.IContactCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContactCategoryServiceImpl implements IContactCategoryService{
    @Autowired
    private ContactCategoryMapper contactCategoryMapper;
    @Override
    public void save(ContactCategory contactCategory) {
        contactCategory.setDate(new Date());
        contactCategory.setNumber(0);
        contactCategoryMapper.insert(contactCategory);
    }

    @Override
    public void delete(Integer id) {
        contactCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ContactCategory contactCategory) {
        contactCategoryMapper.updateByPrimaryKey(contactCategory);
    }

    @Override
    public ContactCategory get(Integer id) {
        return contactCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ContactCategory> getAll() {
        return contactCategoryMapper.selectAll();
    }

}
