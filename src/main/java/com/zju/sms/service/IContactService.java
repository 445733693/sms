package com.zju.sms.service;

import com.zju.sms.domain.Contact;

import java.util.List;

public interface IContactService {
    void save(Contact contact);
    void delete(Integer id);
    void update(Contact contact);
    Contact get(Integer id);
    List<Contact> getAll();
}
