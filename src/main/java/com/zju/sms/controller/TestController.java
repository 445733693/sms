package com.zju.sms.controller;


import com.zju.sms.domain.ContactCategory;
import com.zju.sms.domain.User;
import com.zju.sms.mapper.ContactCategoryMapper;
import com.zju.sms.mapper.UserMapper;
import com.zju.sms.service.IContactCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IContactCategoryService contactCategoryService;
    @Autowired
    private ContactCategoryMapper contactCategoryMapper;

    @RequestMapping("/testUser")
//    @ResponseBody
    public User test1(){
       return userMapper.selectByPrimaryKey("123456");
    }
    @RequestMapping("/test2")
//    @ResponseBody
    public String test2(@RequestBody ContactCategory cc){
        contactCategoryService.save(cc);
        return "success";
    }
    @RequestMapping("/test3")
    public ContactCategory test3(@RequestBody String userId){
        return contactCategoryMapper.selectByPrimaryKey(userId);
    }
    @RequestMapping("/test4")
    public ContactCategory test4(String userId){
        return contactCategoryMapper.selectByPrimaryKey(userId);
    }


}
