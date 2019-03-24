package com.example.demo.service;

import com.example.demo.entity.MessageBoardEntity;
import com.example.demo.mapper.MessageBoardMapper;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageBoardService {
    @Autowired
    MessageBoardMapper messageBoardMapper;
    public MessageBoardEntity getMessage(int id){
        MessageBoardEntity messageBoardEntity = new MessageBoardEntity();
        messageBoardEntity.id = id;
        MessageBoardEntity message = messageBoardMapper.findMessage(id);
        if(message != null){
          message.childContent.addAll(getChildMessage(message.id));
        }
        return message;
    }
    public List<MessageBoardEntity> getChildMessage(int id){
        MessageBoardEntity messageBoardEntity = new MessageBoardEntity();
        messageBoardEntity.pid = id;
        List<MessageBoardEntity> messages = messageBoardMapper.findChildMessage(id);
        if (messages == null){
            return null;
        }
        for (MessageBoardEntity child : messages){
            child.childContent.addAll(getChildMessage(child.id));
        }
        return messages;
    }
    public boolean addMessage(int pid, String message, String name){
        MessageBoardEntity messageBoardEntity = new MessageBoardEntity();
        messageBoardEntity.pid = pid;
        messageBoardEntity.message = message;
        messageBoardEntity.name = name;
        return messageBoardMapper.addMessage(messageBoardEntity);
    }
    public boolean addStar(int id){
        MessageBoardEntity messageBoardEntity = messageBoardMapper.findMessage(id);
        return messageBoardMapper.setStar(messageBoardEntity.star+1,messageBoardEntity.id);
    }
}
