package com.zju.sms.mapper;

import com.zju.sms.domain.InvoiceInfo;
import java.util.List;

public interface InvoiceInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InvoiceInfo record);

    InvoiceInfo selectByPrimaryKey(Integer id);

    List<InvoiceInfo> selectAll();

    int updateByPrimaryKey(InvoiceInfo record);
}