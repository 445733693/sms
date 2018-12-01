package com.zju.sms.controller;

import com.zju.sms.domain.Whitelist;
import com.zju.sms.service.IWhitelistService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhitelistController {
    @Autowired
    private IWhitelistService whitelistService;

    @RequestMapping(value = "/whitelists",method = RequestMethod.POST)
    public String saveWhitelist(@RequestBody Whitelist whitelist){
        whitelistService.save(whitelist);
        return"success";
    }
    @RequestMapping(value = "/whitelists",method = RequestMethod.PUT)
    public String updateWhitelist(@RequestBody Whitelist whitelist){
        Whitelist old = whitelistService.get(whitelist.getId());
        UpdateUtil.updateIfNotNull(old,whitelist);
        whitelistService.update(old);
        return"success";
    }
    @RequestMapping(value = "/whitelists/{id}",method = RequestMethod.DELETE)
    public String deleteWhitelist(@PathVariable("id") Integer id){
        whitelistService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/whitelists/{id}",method = RequestMethod.GET)
    public Whitelist getAdvice(@PathVariable("id") Integer id){
        return whitelistService.get(id);
    }
    @RequestMapping(value = "/whitelists",method = RequestMethod.GET)
    public List<Whitelist> getAdvice(){
        return whitelistService.getAll();
    }
}
