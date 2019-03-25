package com.example.demo.controller;

import com.example.demo.entity.MessageBoardEntity;
import com.example.demo.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageBoardService messageBoardService;
    @GetMapping("/getMessage")
    public List<MessageBoardEntity> getMessage(HttpServletRequest request){
        return messageBoardService.getChildMessage(0,(String)request.getSession(false).getAttribute("username"));
    }
    @PostMapping("/addMessage")
    public boolean addMessage(int pid,String message,HttpServletRequest request){
        return messageBoardService.addMessage(pid,message,(String)request.getSession(false).getAttribute("username"),null);
    }
    @PostMapping("/addSecret")
    public boolean addSecret(int pid,String message, HttpServletRequest request, String secret){
        return messageBoardService.addMessage(pid,message,(String)request.getSession().getAttribute("username"),secret);
    }
    @PostMapping("/addAnonymous")
    public boolean addAnonymous(int pid,String message,HttpServletRequest request){
        return messageBoardService.addMessage(pid,message,null,null);
    }
}
