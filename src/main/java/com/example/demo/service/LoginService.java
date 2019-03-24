package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    public boolean register(UserEntity userEntity){
        UserEntity user = userMapper.findUser(userEntity);
        if(user == null){
            return userMapper.addUser(userEntity);
        }
        return false;
    }
    public boolean login(UserEntity userEntity){
        return userMapper.LoginUser(userEntity) != null;
    }
}
