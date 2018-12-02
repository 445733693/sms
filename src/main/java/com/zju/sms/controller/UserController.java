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
        User old = userService.get(user.getId());
        UpdateUtil.updateIfNotNull(old,user);
        userService.update(old);
        return"success";
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        userService.delete(id);
        return"success";
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id){
        return userService.get(id);
    }
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getUser(){
        return userService.getAll();
    }
//    @RequestMapping(value = "/admins",method = RequestMethod.GET)
//    public User getUser(@RequestBody String username){
//        return userService.getByUsername(username);
//    }

}
