package com.zju.sms.service;

import com.zju.sms.domain.SendRecord;

import java.util.List;

public interface ISendRecordService {
    void save(SendRecord sendRecord);
    void delete(Integer id);
    void update(SendRecord sendRecord);
    SendRecord get(Integer id);
    List<SendRecord> getAll();
}
