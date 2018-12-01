package com.zju.sms.controller;

import com.zju.sms.domain.RechargeSolution;
import com.zju.sms.service.IRechargeSolutionService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RechargeSolutionController {
    @Autowired
    private IRechargeSolutionService rechargeSolutionService;

    @RequestMapping(value = "/rechargeSolutions",method = RequestMethod.POST)
    public String saveRechargeSolution(@RequestBody RechargeSolution rechargeSolution){
        rechargeSolutionService.save(rechargeSolution);
        return"success";
    }
    @RequestMapping(value = "/rechargeSolutions",method = RequestMethod.PUT)
    public String updateRechargeSolution(@RequestBody RechargeSolution rechargeSolution){
        RechargeSolution old = rechargeSolutionService.get(rechargeSolution.getId());
        UpdateUtil.updateIfNotNull(old,rechargeSolution);
        rechargeSolutionService.update(old);
        return"success";
    }
    @RequestMapping(value = "/rechargeSolutions/{id}",method = RequestMethod.DELETE)
    public String deleteRechargeSolution(@PathVariable("id") Integer id){
        rechargeSolutionService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/rechargeSolutions/{id}",method = RequestMethod.GET)
    public RechargeSolution getRechargeSolution(@PathVariable("id") Integer id){
        return rechargeSolutionService.get(id);
    }
    @RequestMapping(value = "/rechargeSolutions",method = RequestMethod.GET)
    public List<RechargeSolution> getAdvice(){
        return rechargeSolutionService.getAll();
    }
}
