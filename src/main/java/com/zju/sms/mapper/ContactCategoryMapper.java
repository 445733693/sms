package com.zju.sms.mapper;

import com.zju.sms.domain.ContactCategory;
import java.util.List;

public interface ContactCategoryMapper {
    int deleteByPrimaryKey(String userId);

    int insert(ContactCategory record);

    ContactCategory selectByPrimaryKey(String userId);

    List<ContactCategory> selectAll();

    int updateByPrimaryKey(ContactCategory record);
}