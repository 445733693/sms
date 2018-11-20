package com.zju.sms.mapper;

import com.zju.sms.domain.Advice;
import java.util.List;

public interface AdviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Advice record);

    Advice selectByPrimaryKey(Integer id);

    List<Advice> selectAll();

    int updateByPrimaryKey(Advice record);
}