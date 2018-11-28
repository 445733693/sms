package com.zju.sms.service;

import com.zju.sms.domain.ContactCategory;

import java.util.List;

public interface IContactCategoryService {
    void save(ContactCategory contactCategory);
    void delete(String  userId);
    void update(ContactCategory contactCategory);
    ContactCategory get(String  userId);
    List<ContactCategory> getAll();
}
