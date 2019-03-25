package com.example.demo.mapper;

import com.example.demo.entity.MessageBoardEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageBoardMapper {
    @Insert("insert into message_board(pid,message,star,name,secret) value (#{pid},#{message},0,#{name},#{secret})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    boolean addMessage(MessageBoardEntity messageBoardEntity);
    @Select("select*from message_board where id = #{id}")
    MessageBoardEntity findMessage(int id);
    @Select("select*from message_board where pid = #{pid}")
    List<MessageBoardEntity> findChildMessage(int pid);
    @Update("update message_board set star = #{star} where id = #{id}")
    boolean setStar(@Param("star") int star,@Param("id")int id);
    @Delete("delete from message_board where id = #{id}")
    boolean deleteMessage(int id);
}
