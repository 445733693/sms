package com.zju.sms.service;

import com.zju.sms.domain.InvoiceInfo;

import java.util.List;

public interface IInvoiceInfoService {
    void save(InvoiceInfo invoiceInfo);
    void delete(String userId);
    void update(InvoiceInfo invoiceInfo);
    InvoiceInfo get(String userId);
    List<InvoiceInfo> getAll();
}