package com.zju.sms.controller;

import com.zju.sms.domain.Announcement;
import com.zju.sms.service.IAnnouncementService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnouncementController {
    @Autowired
    private IAnnouncementService announcementService;

    @RequestMapping(value = "/announcements",method = RequestMethod.POST)
    @RequiresPermissions("announcements:save")
    @PermissionName("公告添加")
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
    @RequiresPermissions("announcements:delete")
    @PermissionName("公告删除")
    public String deleteAnnouncement(@PathVariable("id") Integer id){
        announcementService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/announcements/{id}",method = RequestMethod.GET)
    @RequiresPermissions("announcements:get")
    @PermissionName("公告查询")
    public Announcement getAnnouncement(@PathVariable("id") Integer id){
        return announcementService.get(id);
    }

    @RequestMapping(value = "/announcements",method = RequestMethod.GET)
    @RequiresPermissions("announcements:list")
    @PermissionName("公告列表")
    public List<Announcement> getAnnouncement(){
        return announcementService.getAll();
    }
}
