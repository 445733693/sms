package com.zju.sms.service.impl;

import com.zju.sms.mapper.MessageDraftMapper;
import com.zju.sms.service.IMessageDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MessageDraftServiceImpl implements IMessageDraftService {
    @Autowired
    private MessageDraftMapper messageDraftMapper;

    @Override
    public void save(MessageDraft messageDraft) {
        messageDraft.setDate(new Date());
        messageDraftMapper.insert(messageDraft);
    }

    @Override
    public void delete(Integer id) {
        messageDraftMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(MessageDraft messageDraft) {
        messageDraftMapper.updateByPrimaryKey(messageDraft);
    }

    @Override
    public MessageDraft get(Integer id) {
        return messageDraftMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MessageDraft> getAll() {
        return messageDraftMapper.selectAll();
    }
}
