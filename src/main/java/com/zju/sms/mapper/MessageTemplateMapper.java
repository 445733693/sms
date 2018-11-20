package com.zju.sms.mapper;

import com.zju.sms.domain.MessageTemplate;
import java.util.List;

public interface MessageTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageTemplate record);

    MessageTemplate selectByPrimaryKey(Integer id);

    List<MessageTemplate> selectAll();

    int updateByPrimaryKey(MessageTemplate record);
}