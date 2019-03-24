package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user(uid,name,password,sex) value('${uid}','${name}','${password}','${sex}') ")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    boolean addUser(UserEntity userEntity);
    @Select("select*from user where name = '${name}'or uid = '${uid}'")
    UserEntity findUser(UserEntity userEntity);
    @Select("select*from user where password = '${password}' or '${name}'")
    UserEntity LoginUser(UserEntity userEntity);
}
