package com.zju.sms.controller;

import com.zju.sms.domain.User;
import com.zju.sms.service.IUserService;
import com.zju.sms.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public String saveUser(@RequestBody User user){
        userService.save(user);
        return"success";
    }
    @RequestMapping(value = "/users",method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user){
        User old = userService.get(user.getUserId());
        UpdateUtil.updateIfNotNull(old,user);
        userService.update(old);
        return"success";
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") String userId){
        userService.delete(userId);
        return"success";
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable("id") String userId){
        return userService.get(userId);
    }
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getUser(){
        return userService.getAll();
    }
}
