package com.zju.sms.mapper;

import com.zju.sms.domain.InvoiceInfo;
import java.util.List;

public interface InvoiceInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(InvoiceInfo record);

    InvoiceInfo selectByPrimaryKey(String userId);

    List<InvoiceInfo> selectAll();

    int updateByPrimaryKey(InvoiceInfo record);
}