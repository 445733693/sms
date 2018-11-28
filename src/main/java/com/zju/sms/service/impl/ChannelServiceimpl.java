package com.zju.sms.service.impl;

import com.zju.sms.mapper.ChannelMapper;
import com.zju.sms.service.IChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceimpl implements IChannelService {
    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public void save(Channel channel) {
        channelMapper.insert(channel);
    }

    @Override
    public void delete(Integer id) {
        channelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Channel channel) {
        channelMapper.updateByPrimaryKey(channel);
    }

    @Override
    public Channel get(Integer id) {
        return channelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Channel> getAll() {
        return channelMapper.selectAll();
    }
}
