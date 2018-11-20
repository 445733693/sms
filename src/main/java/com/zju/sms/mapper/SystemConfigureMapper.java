package com.zju.sms.mapper;

import com.zju.sms.domain.SystemConfigure;
import java.util.List;

public interface SystemConfigureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemConfigure record);

    SystemConfigure selectByPrimaryKey(Integer id);

    List<SystemConfigure> selectAll();

    int updateByPrimaryKey(SystemConfigure record);
}