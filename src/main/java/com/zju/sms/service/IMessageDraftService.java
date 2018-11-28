package com.zju.sms.service;

import java.util.List;

public interface IMessageDraftService {
    void save(MessageDraft messageDraft);
    void delete(Integer id);
    void update(MessageDraft messageDraft);
    MessageDraft get(Integer id);
    List<MessageDraft> getAll();
}
