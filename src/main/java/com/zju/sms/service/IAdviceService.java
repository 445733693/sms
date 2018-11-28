package com.zju.sms.service;

import java.util.List;

public interface IAdviceService {
    void save(Advice advice);
    void delete(Integer id);
    void update(Advice advice);
    Advice get(Integer id);
    List<Advice> getAll();
}
