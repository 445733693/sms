package com.zju.sms.service.impl;

import com.zju.sms.domain.MessageTemplate;
import com.zju.sms.mapper.MessageTemplateMapper;
import com.zju.sms.service.IMessageTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MessageTemplateServiceImpl implements IMessageTemplateService {
    @Autowired
    private MessageTemplateMapper messageTemplateMapper;

    @Override
    public void save(MessageTemplate messageTemplate) {
        messageTemplate.setDate(new Date());
        messageTemplateMapper.insert(messageTemplate);
    }

    @Override
    public void delete(Integer id) {
        messageTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(MessageTemplate messageTemplate) {
        messageTemplateMapper.updateByPrimaryKey(messageTemplate);
    }

    @Override
    public MessageTemplate get(Integer id) {
        return messageTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MessageTemplate> getAll() {
        return messageTemplateMapper.selectAll();
    }
}
