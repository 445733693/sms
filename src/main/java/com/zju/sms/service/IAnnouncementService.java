package com.zju.sms.service;

import com.zju.sms.domain.Announcement;

import java.util.List;

public interface IAnnouncementService {
    void save(Announcement announcement);
    void delete(Integer id);
    void update(Announcement announcement);
    Announcement get(Integer id);
    List<Announcement> getAll();
}
