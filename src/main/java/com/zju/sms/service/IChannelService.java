package com.zju.sms.service;

import com.zju.sms.domain.Channel;
import java.util.List;

public interface IChannelService {
    void save(Channel channel);
    void delete(Integer id);
    void update(Channel channel);
    Channel get(Integer id);
    List<Channel> getAll();
}
