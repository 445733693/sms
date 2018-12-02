package com.zju.sms.controller;

import com.zju.sms.domain.Channel;
import com.zju.sms.service.IChannelService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {
    @Autowired
    private IChannelService channelService;

    @RequestMapping(value = "/channels",method = RequestMethod.POST)
    public String saveChannel(@RequestBody Channel channel){
        channelService.save(channel);
        return"success";
    }
    @RequestMapping(value = "/channels",method = RequestMethod.PUT)
    public String updateChannel(@RequestBody Channel channel){
        Channel old = channelService.get(channel.getId());
        UpdateUtil.updateIfNotNull(old,channel);
        channelService.update(old);
        return"success";
    }
    @RequestMapping(value = "/channels/{id}",method = RequestMethod.DELETE)
    public String deleteChannel(@PathVariable("id") Integer id){
        channelService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/channels/{id}",method = RequestMethod.GET)
    public Channel getChannel(@PathVariable("id") Integer id){
        return channelService.get(id);
    }
    @RequestMapping(value = "/channels",method = RequestMethod.GET)
    public List<Channel> getChannel(){
        return channelService.getAll();
    }
}
