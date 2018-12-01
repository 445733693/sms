package com.zju.sms.service;

import com.zju.sms.domain.MessageTemplate;

import java.util.List;

public interface IMessageTemplateService {
    void save(MessageTemplate messageTemplate);
    void delete(Integer id);
    void update(MessageTemplate messageTemplate);
    MessageTemplate get(Integer id);
    List<MessageTemplate> getAll();
}
