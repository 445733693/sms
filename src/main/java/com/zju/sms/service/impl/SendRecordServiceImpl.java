package com.zju.sms.service.impl;

import com.zju.sms.domain.SendRecord;
import com.zju.sms.mapper.SendRecordMapper;
import com.zju.sms.service.ISendRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class SendRecordServiceImpl implements ISendRecordService {
    @Autowired
    private SendRecordMapper sendRecordMapper;

    @Override
    public void save(SendRecord sendRecord) {
        sendRecord.setDate(new Date());
        sendRecordMapper.insert(sendRecord);
    }

    @Override
    public void delete(Integer id) {
        sendRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(SendRecord sendRecord) {
        sendRecordMapper.updateByPrimaryKey(sendRecord);
    }

    @Override
    public SendRecord get(Integer id) {
        return sendRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SendRecord> getAll() {
        return sendRecordMapper.selectAll();
    }
}
