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
    private ContactCategoryMapper mapper;
    @Override
    public void save(ContactCategory contactCategory) {
        contactCategory.setDate(new Date());
        contactCategory.setNumber(0);
        mapper.insert(contactCategory);
    }

    @Override
    public void delete(String  userId) {

    }

    @Override
    public void update(ContactCategory contactCategory) {

    }

    @Override
    public ContactCategory get(String  userId) {
        return null;
    }

    @Override
    public List<ContactCategory> getAll() {
        return null;
    }

}
