package com.zju.sms.service.impl;

import com.zju.sms.domain.Keyword;
import com.zju.sms.mapper.KeywordMapper;
import com.zju.sms.service.IKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl implements IKeywordService {
    @Autowired
    private KeywordMapper keywordMapper;
    @Override
    public void save(Keyword keyword) {
        keywordMapper.insert(keyword);
    }

    @Override
    public void delete(Integer id) {
        keywordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Keyword keyword) {
        keywordMapper.updateByPrimaryKey(keyword);
    }

    @Override
    public Keyword get(Integer id) {
        return keywordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Keyword> getAll() {
        return keywordMapper.selectAll();
    }
}
