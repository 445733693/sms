package com.zju.sms.controller;

import com.zju.sms.domain.Keyword;
import com.zju.sms.service.IKeywordService;
import com.zju.sms.shiro.PermissionName;
import com.zju.sms.util.UpdateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeywordController {
    @Autowired
    private IKeywordService keywordService;

    @RequestMapping(value = "/keywords",method = RequestMethod.POST)
    @RequiresPermissions("keywords:save")
    @PermissionName("关键字添加")
    public String saveKeyword(@RequestBody Keyword keyword){
        keywordService.save(keyword);
        return"success";
    }
    @RequestMapping(value = "/keywords",method = RequestMethod.PUT)
    @RequiresPermissions("keywords:edit")
    @PermissionName("关键字修改")
    public String updateKeyword(@RequestBody Keyword keyword){
        Keyword old = keywordService.get(keyword.getId());
        UpdateUtil.updateIfNotNull(old,keyword);
        keywordService.update(old);
        return"success";
    }
    @RequestMapping(value = "/keywords/{id}",method = RequestMethod.DELETE)
    @RequiresPermissions("keywords:delete")
    @PermissionName("关键字删除")
    public String deleteKeyword(@PathVariable("id") Integer id){
        keywordService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/keywords/{id}",method = RequestMethod.GET)
    @RequiresPermissions("keywords:get")
    @PermissionName("关键字查询")
    public Keyword getKeyword(@PathVariable("id") Integer id){
        return keywordService.get(id);
    }

    @RequestMapping(value = "/keywords",method = RequestMethod.GET)
    @RequiresPermissions("keywords:list")
    @PermissionName("关键字列表")
    public List<Keyword> getKeyword(){
        return keywordService.getAll();
    }
}
