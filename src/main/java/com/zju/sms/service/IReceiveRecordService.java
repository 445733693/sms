package com.zju.sms.service;

import java.util.List;

public interface IReceiveRecordService {
    void save(ReceiveRecord receiveRecord);
    void delete(Integer id);
    void update(ReceiveRecord receiveRecord);
    ReceiveRecord get(Integer id);
    List<ReceiveRecord> getAll();
}
