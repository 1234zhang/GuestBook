package com.example.demo.service;

import com.example.demo.entity.MessageBoardEntity;
import com.example.demo.mapper.MessageBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageBoardService {
    @Autowired
    MessageBoardMapper messageBoardMapper;
    public MessageBoardEntity getMessage(int id,String name){
        MessageBoardEntity message = messageBoardMapper.findMessage(id);
        if(message != null && (name.equals(message.secret) || message.secret == null)){
          message.childContent.addAll(getChildMessage(message.id,name));
          return message;
        }
        return null;
    }
    public List<MessageBoardEntity> getChildMessage(int id,String name){
        MessageBoardEntity messageBoardEntity = new MessageBoardEntity();
        messageBoardEntity.pid = id;
        List<MessageBoardEntity> messages = messageBoardMapper.findChildMessage(id);
        List<MessageBoardEntity> messageList = new ArrayList<>();
        if (messages == null){
            return null;
        }
        for (MessageBoardEntity child : messages){
            if(name.equals(child.secret) || child.secret == null){
                child.childContent.addAll(getChildMessage(child.id,name));
                messageList.add(child);
            }

        }
        return messageList;
    }
    public boolean addMessage(int pid, String message, String name,String secret){
        MessageBoardEntity messageBoardEntity = new MessageBoardEntity();
        messageBoardEntity.pid = pid;
        messageBoardEntity.message = message;
        messageBoardEntity.name = name;
        messageBoardEntity.secret = secret;
        return messageBoardMapper.addMessage(messageBoardEntity);
    }
    public boolean addStar(int id){
        MessageBoardEntity messageBoardEntity = messageBoardMapper.findMessage(id);
        return messageBoardMapper.setStar(messageBoardEntity.star+1,messageBoardEntity.id);
    }
    public boolean deleteMessage(int id){
        return messageBoardMapper.deleteMessage(id);
    }
}
