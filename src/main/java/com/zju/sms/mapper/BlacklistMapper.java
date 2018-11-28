package com.zju.sms.mapper;

import com.zju.sms.domain.Blacklist;
import com.zju.sms.domain.BlacklistWithBLOBs;
import java.util.List;

public interface BlacklistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Blacklist record);

    BlacklistWithBLOBs selectByPrimaryKey(Integer id);

    List<Blacklist> selectAll();

    int updateByPrimaryKey(Blacklist record);
}