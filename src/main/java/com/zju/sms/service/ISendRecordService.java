package com.zju.sms.service;

import java.util.List;

public interface ISendRecordService {
    void save(SendRecord sendRecord);
    void delete(Integer id);
    void update(SendRecord sendRecord);
    SendRecord get(Integer id);
    List<SendRecord> getAll();
}
