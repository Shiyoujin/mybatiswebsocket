package com.example.mybatiswebsocket.service;

import com.example.mybatiswebsocket.mapper.RoomMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author white matter
 */
@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;

    public boolean checkRoom(int roomNumber){
        if (roomMapper.checkRoom(roomNumber)!=0){
            return false;
        }else {
            //如果为空
            return true;
        }
    }

    public boolean checkplayer1(int roomNumber){
        if (roomMapper.checkPlayer1(roomNumber)!=0){
            return false;
        }else {
            //如果为空
            return true;
        }
    }




    public boolean joinRoom(int roomNumber,String player1){
        if (checkRoom(roomNumber)){
            int result = roomMapper.joinRoom(roomNumber,player1);
            if (result == 1){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean updatePlayer1(int roomNumber,String plaer1){
        int result = roomMapper.updatePlayer1(roomNumber,plaer1);
        if (result==1){
            return true;
        }else {
            return false;
        }
    }

    public boolean updatePlayer2(int roomNumber,String player2){
        int result = roomMapper.updatePlayer2(roomNumber,player2);
        if (result==1){
            return true;
        }else {
            return false;
        }
    }

    public boolean joinWatching(int roomNumber,String watching){
        int result = roomMapper.joinWatching(roomNumber,watching);
        if (result==1){
            return true;
        }else {
            return false;
        }
    }

}
