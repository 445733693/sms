package com.zju.sms.service;

import com.zju.sms.domain.InvoiceInfo;

import java.util.List;

public interface IInvoiceInfoService {
    void save(InvoiceInfo invoiceInfo);
    void delete(Integer id);
    void update(InvoiceInfo invoiceInfo);
    InvoiceInfo get(Integer id);
    List<InvoiceInfo> getAll();
}
