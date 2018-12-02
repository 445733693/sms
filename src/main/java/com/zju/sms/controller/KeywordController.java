package com.zju.sms.controller;

import com.zju.sms.domain.Keyword;
import com.zju.sms.service.IKeywordService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeywordController {
    @Autowired
    private IKeywordService keywordService;

    @RequestMapping(value = "/keywords",method = RequestMethod.POST)
    public String saveKeyword(@RequestBody Keyword keyword){
        keywordService.save(keyword);
        return"success";
    }
    @RequestMapping(value = "/keywords",method = RequestMethod.PUT)
    public String updateKeyword(@RequestBody Keyword keyword){
        Keyword old = keywordService.get(keyword.getId());
        UpdateUtil.updateIfNotNull(old,keyword);
        keywordService.update(old);
        return"success";
    }
    @RequestMapping(value = "/keywords/{id}",method = RequestMethod.DELETE)
    public String deleteKeyword(@PathVariable("id") Integer id){
        keywordService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/keywords/{id}",method = RequestMethod.GET)
    public Keyword getKeyword(@PathVariable("id") Integer id){
        return keywordService.get(id);
    }
    @RequestMapping(value = "/keywords",method = RequestMethod.GET)
    public List<Keyword> getKeyword(){
        return keywordService.getAll();
    }
}
