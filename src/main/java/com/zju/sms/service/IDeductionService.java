package com.zju.sms.service;

import com.zju.sms.domain.Deduction;

import java.util.List;

public interface IDeductionService {
    void save(Deduction deduction);
    void delete(Integer id);
    void update(Deduction deduction);
    Deduction get(Integer id);
    List<Deduction> getAll();
}
