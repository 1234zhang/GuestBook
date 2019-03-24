package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public String register(UserEntity userEntity){
        if(loginService.register(userEntity)){
            return "10001:注册成功";
        }
        return "10000:注册失败";
    }
    @PostMapping("/login")
    public String login(String name,String password,HttpServletRequest request){
        UserEntity userEntity = new UserEntity();
        userEntity.name = name;
        userEntity.password = password;
        if(loginService.login(userEntity)){
            request.getSession().setAttribute("username",userEntity.name);
            return "10001 : success login!";
        }
        return "10000 : the user is not exist";
    }
    @RequestMapping("/out")
    public void loginOut(HttpServletRequest request){
        request.getSession(false).invalidate();
    }
}
