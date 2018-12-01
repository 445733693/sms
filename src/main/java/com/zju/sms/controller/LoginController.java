package com.zju.sms.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zju.sms.shiro.LoginType;
import com.zju.sms.shiro.UsernamePasswordTypeToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    Logger log=Logger.getLogger(LoginController.class);
    private static final String USER_LOGIN_TYPE= LoginType.USER.toString();
    private static final String AGENT_LOGIN_TYPE= LoginType.AGENT.toString();
    private static final String ADMIN_LOGIN_TYPE= LoginType.ADMIN.toString();

    //后端测试转login.jsp用，前后端分离后删去
    @RequestMapping("")
    public String login(){
        log.info("转到登陆界面");
        return "login";
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public String loginuser(@RequestParam(value = "username",required = false) String username,
                        @RequestParam(value = "password",required = false) String password, Model model){
        System.out.println("用户登陆验证....");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordTypeToken(username, password,USER_LOGIN_TYPE);
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            model.addAttribute("errorMsg","账号/密码错误");
            return "login";
        }
        return "mainuser";
    }

    @RequestMapping(value = "/agent" ,method = RequestMethod.POST)
    public String loginagent(@RequestParam(value = "username",required = false) String username,
                            @RequestParam(value = "password",required = false) String password, Model model){
        System.out.println("用户登陆验证....");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordTypeToken(username, password,AGENT_LOGIN_TYPE);
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            model.addAttribute("errorMsg","账号/密码错误");
            return "login";
        }
        return "mainagent";
    }

    @RequestMapping(value = "/admin" ,method = RequestMethod.POST)
    public String loginadmin(@RequestParam(value = "username",required = false) String username,
                            @RequestParam(value = "password",required = false) String password, Model model){
        System.out.println("用户登陆验证....");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordTypeToken(username, password,ADMIN_LOGIN_TYPE);
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            model.addAttribute("errorMsg","账号/密码错误");
            return "login";
        }
        return "mainadmin";
    }
}
