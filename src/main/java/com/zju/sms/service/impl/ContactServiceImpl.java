package com.zju.sms.service.impl;

import com.zju.sms.domain.Contact;
import com.zju.sms.mapper.ContactMapper;
import com.zju.sms.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ContactServiceImpl implements IContactService {
    @Autowired
    private ContactMapper contactMapper;

    @Override
    public void save(Contact contact) {
        contact.setAddTime(new Date());
        contactMapper.insert(contact);
    }

    @Override
    public void delete(Integer id) {
        contactMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Contact contact) {
        contactMapper.updateByPrimaryKey(contact);
    }

    @Override
    public Contact get(Integer id) {
        return contactMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Contact> getAll() {
        return contactMapper.selectAll();
    }
}
