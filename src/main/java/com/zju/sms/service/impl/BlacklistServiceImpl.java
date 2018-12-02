package com.zju.sms.service.impl;

import com.zju.sms.domain.Blacklist;
import com.zju.sms.mapper.BlacklistMapper;
import com.zju.sms.service.IBlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlacklistServiceImpl implements IBlacklistService {
    @Autowired
    private BlacklistMapper blacklistMapper;

    @Override
    public void save(Blacklist blacklist) {
        blacklistMapper.insert(blacklist);
    }

    @Override
    public void delete(Integer id) {
        blacklistMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Blacklist blacklist) {
        blacklistMapper.updateByPrimaryKey(blacklist);
    }

    @Override
    public Blacklist get(Integer id) {
        return blacklistMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Blacklist> getAll() {
        return blacklistMapper.selectAll();
    }
}
