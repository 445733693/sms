package com.zju.sms.controller;

import com.zju.sms.domain.Announcement;
import com.zju.sms.service.IAnnouncementService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnouncementController {
    @Autowired
    private IAnnouncementService announcementService;

    @RequestMapping(value = "/announcements",method = RequestMethod.POST)
    public String saveAnnouncement(@RequestBody Announcement announcement){
        announcementService.save(announcement);
        return"success";
    }
    @RequestMapping(value = "/announcements",method = RequestMethod.PUT)
    public String updateAnnouncement(@RequestBody Announcement announcement){
        Announcement old = announcementService.get(announcement.getId());
        UpdateUtil.updateIfNotNull(old,announcement);
        announcementService.update(old);
        return"success";
    }
    @RequestMapping(value = "/announcements/{id}",method = RequestMethod.DELETE)
    public String deleteAnnouncement(@PathVariable("id") Integer id){
        announcementService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/announcements/{id}",method = RequestMethod.GET)
    public Announcement getAnnouncement(@PathVariable("id") Integer id){
        return announcementService.get(id);
    }
    @RequestMapping(value = "/announcements",method = RequestMethod.GET)
    public List<Announcement> getAnnouncement(){
        return announcementService.getAll();
    }
}
