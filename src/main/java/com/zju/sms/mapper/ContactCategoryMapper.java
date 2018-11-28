package com.zju.sms.mapper;

import com.zju.sms.domain.ContactCategory;
import java.util.List;

public interface ContactCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContactCategory record);

    ContactCategory selectByPrimaryKey(Integer id);

    List<ContactCategory> selectAll();

    int updateByPrimaryKey(ContactCategory record);
}