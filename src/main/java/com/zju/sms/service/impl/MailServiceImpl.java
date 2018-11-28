package com.zju.sms.service.impl;

import com.zju.sms.mapper.MailMapper;
import com.zju.sms.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class MailServiceImpl implements IMailService {
    @Autowired
    private MailMapper mailMapper;

    @Override
    public void save(Mail mail) {
        mail.setDate(new Date());
        mailMapper.insert(mail);
    }

    @Override
    public void delete(Integer id) {
        mailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Mail mail) {
        mailMapper.updateByPrimaryKey(mail);
    }

    @Override
    public Mail get(Integer id) {
        return mailMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Mail> getAll() {
        return mailMapper.selectAll();
    }
}
