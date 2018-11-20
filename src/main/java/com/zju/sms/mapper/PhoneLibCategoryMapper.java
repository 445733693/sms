package com.zju.sms.mapper;

import com.zju.sms.domain.PhoneLibCategory;
import java.util.List;

public interface PhoneLibCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PhoneLibCategory record);

    PhoneLibCategory selectByPrimaryKey(Integer id);

    List<PhoneLibCategory> selectAll();

    int updateByPrimaryKey(PhoneLibCategory record);
}