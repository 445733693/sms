package com.zju.sms.mapper;

import com.zju.sms.domain.TemplateCategory;
import java.util.List;

public interface TemplateCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TemplateCategory record);

    TemplateCategory selectByPrimaryKey(Integer id);

    List<TemplateCategory> selectAll();

    int updateByPrimaryKey(TemplateCategory record);
}