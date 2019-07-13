package com.example.mybatiswebsocket.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author white matter
 */
@Mapper
@Component
public interface RoomMapper {

    @Select("select ifnull((select id from room where roomNunber = #{roomNumber}),0)")
    int checkRoom(int roomNumber);

    @Select("select ifnull((select player1 from room where roomNumber = #{roomNumber}),0)")
    int checkPlayer1(int roomNumber);

    @Insert("insert into room(roomNumber player1) value(#{roomNumber},#{player1})")
    int joinRoom(int roomNumber,String player1);

    @Update("update room set player1 = #{player1} where roomNumber = #{roomNumber}")
    int updatePlayer1(int roomNumber,String player1);

    @Update("update room set player2 = #{player2} where roomNumber = #{roomNumber}")
    int updatePlayer2(int roomNumber,String player2);

    //这里使用的concat函数，可以在原有字段的 前面或者后面添加字段，也可以前后一起添加
    @Update("update room set watching = concat(',',watching,#{watching}) where roomNumber = #{roomNumber}")
    int joinWatching(@Param("roomNumber") int roomNumber, @Param("watching") String watching);
}

