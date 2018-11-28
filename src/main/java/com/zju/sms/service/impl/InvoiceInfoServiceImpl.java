package com.zju.sms.service.impl;

import com.zju.sms.mapper.InvoiceInfoMapper;
import com.zju.sms.service.IInvoiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceInfoServiceImpl implements IInvoiceInfoService {
    @Autowired
    private InvoiceInfoMapper invoiceInfoMapper;

    @Override
    public void save(InvoiceInfo invoiceInfo) {
        invoiceInfoMapper.insert(invoiceInfo);
    }

    @Override
    public void delete(String userId) {
        invoiceInfoMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void update(InvoiceInfo invoiceInfo) {
        invoiceInfoMapper.updateByPrimaryKey(invoiceInfo);
    }

    @Override
    public InvoiceInfo get(String userId) {
        return invoiceInfoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<InvoiceInfo> getAll() {
        return invoiceInfoMapper.selectAll();
    }
}
