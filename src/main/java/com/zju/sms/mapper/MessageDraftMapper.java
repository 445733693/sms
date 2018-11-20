package com.zju.sms.mapper;

import com.zju.sms.domain.MessageDraft;
import java.util.List;

public interface MessageDraftMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageDraft record);

    MessageDraft selectByPrimaryKey(Integer id);

    List<MessageDraft> selectAll();

    int updateByPrimaryKey(MessageDraft record);
}