package com.zju.sms.mapper;

import com.zju.sms.domain.ContactCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactCategoryMapper {
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("categoryName") String categoryName);

    int insert(ContactCategory record);

    ContactCategory selectByPrimaryKey(@Param("userId") String userId, @Param("categoryName") String categoryName);

    List<ContactCategory> selectAll();

    int updateByPrimaryKey(ContactCategory record);
}