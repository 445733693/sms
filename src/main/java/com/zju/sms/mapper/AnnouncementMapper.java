package com.zju.sms.mapper;

import com.zju.sms.domain.Announcement;
import java.util.List;

public interface AnnouncementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Announcement record);

    Announcement selectByPrimaryKey(Integer id);

    List<Announcement> selectAll();

    int updateByPrimaryKey(Announcement record);
}