package com.zju.sms.service;

import com.zju.sms.domain.Mail;

import java.util.List;

public interface IMailService {
    void save(Mail mail);
    void delete(Integer id);
    void update(Mail mail);
    Mail get(Integer id);
    List<Mail> getAll();
}
