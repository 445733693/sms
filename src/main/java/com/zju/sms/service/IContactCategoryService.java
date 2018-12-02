package com.zju.sms.service;

import com.zju.sms.domain.ContactCategory;

import java.util.List;

public interface IContactCategoryService {
    void save(ContactCategory contactCategory);
    void delete(Integer id);
    void update(ContactCategory contactCategory);
    ContactCategory get(Integer id);
    List<ContactCategory> getAll();
}
