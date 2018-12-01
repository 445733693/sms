package com.zju.sms.service;

import com.zju.sms.domain.Keyword;

import java.util.List;

public interface IKeywordService {
    void save(Keyword keyword);
    void delete(Integer id);
    void update(Keyword keyword);
    Keyword get(Integer id);
    List<Keyword> getAll();
}
