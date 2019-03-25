package com.example.demo.controller;

import com.example.demo.entity.MessageBoardEntity;
import com.example.demo.mapper.MessageBoardMapper;
import com.example.demo.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    MessageBoardService messageBoardService;
    @RequestMapping("/test")
    public boolean test(int pid,String message,String secret){
        return messageBoardService.addMessage(pid,message,"sdf",null);
    }
    @RequestMapping("/get")
    public List<MessageBoardEntity> get(){
        return messageBoardService.getChildMessage(0,"abc");
    }
}
