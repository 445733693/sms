package com.zju.sms.service.impl;

import com.zju.sms.domain.Whitelist;
import com.zju.sms.mapper.WhitelistMapper;
import com.zju.sms.service.IWhitelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhitelistServiceImpl implements IWhitelistService {
    @Autowired
    private WhitelistMapper whitelistMapper;

    @Override
    public void save(Whitelist whitelist) {
        whitelistMapper.insert(whitelist);
    }

    @Override
    public void delete(Integer id) {
        whitelistMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Whitelist whitelist) {
        whitelistMapper.updateByPrimaryKey(whitelist);
    }

    @Override
    public Whitelist get(Integer id) {
        return whitelistMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Whitelist> getAll() {
        return whitelistMapper.selectAll();
    }
}
