package com.example.demo.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MessageBoardEntity {
    public int id;
    public int pid = 0;
    public String message;
    public int star;
    public String name;
    public List<MessageBoardEntity> childContent = new ArrayList<>();

}
