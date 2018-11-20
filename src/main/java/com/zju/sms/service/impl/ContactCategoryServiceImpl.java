package com.zju.sms.service.impl;

import com.zju.sms.domain.ContactCategory;
import com.zju.sms.mapper.ContactCategoryMapper;
import com.zju.sms.service.IContactCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ContactCategoryServiceImpl implements IContactCategoryService{
    @Autowired
    private ContactCategoryMapper mapper;
    @Override
    public void save(ContactCategory contactCategory) {
        contactCategory.setDate(new Date());
        mapper.insert(contactCategory);
    }
}
