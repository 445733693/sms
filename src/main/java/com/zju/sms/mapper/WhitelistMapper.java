package com.zju.sms.mapper;

import com.zju.sms.domain.Whitelist;
import com.zju.sms.domain.WhitelistWithBLOBs;
import java.util.List;

public interface WhitelistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Whitelist record);

    WhitelistWithBLOBs selectByPrimaryKey(Integer id);

    List<Whitelist> selectAll();

    int updateByPrimaryKey(Whitelist record);
}