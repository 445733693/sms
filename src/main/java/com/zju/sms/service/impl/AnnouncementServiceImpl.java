package com.zju.sms.service.impl;

import com.zju.sms.mapper.AnnouncementMapper;
import com.zju.sms.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {
    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public void save(Announcement announcement) {
        announcement.setDate(new Date());
        announcementMapper.insert(announcement);
    }

    @Override
    public void delete(Integer id) {
        announcementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Announcement announcement) {
        announcementMapper.updateByPrimaryKey(announcement);
    }

    @Override
    public Announcement get(Integer id) {
        return announcementMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Announcement> getAll() {
        return announcementMapper.selectAll();
    }
}
