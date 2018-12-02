package com.zju.sms.mapper;

import com.zju.sms.domain.Whitelist;
import java.util.List;

public interface WhitelistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Whitelist record);

    Whitelist selectByPrimaryKey(Integer id);

    List<Whitelist> selectAll();

    int updateByPrimaryKey(Whitelist record);
}