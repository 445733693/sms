package com.zju.sms.mapper;

import com.zju.sms.domain.Channel;
import java.util.List;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    Channel selectByPrimaryKey(Integer id);

    List<Channel> selectAll();

    int updateByPrimaryKey(Channel record);
}