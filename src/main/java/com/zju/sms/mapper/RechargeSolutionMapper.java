package com.zju.sms.mapper;

import com.zju.sms.domain.RechargeSolution;
import java.util.List;

public interface RechargeSolutionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeSolution record);

    RechargeSolution selectByPrimaryKey(Integer id);

    List<RechargeSolution> selectAll();

    int updateByPrimaryKey(RechargeSolution record);
}