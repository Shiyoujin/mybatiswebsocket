package com.example.mybatiswebsocket.server;

import com.example.mybatiswebsocket.config.GetHttpSessionConfigurator;
import com.example.mybatiswebsocket.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


/**
 * @author white matter
 */
@ServerEndpoint(value = "/{u_name}/{u_id}/{roomNumber}", configurator = GetHttpSessionConfigurator.class)
@Component
public class FiveGameServer {

    //https://blog.csdn.net/qq1169091731/article/details/83067069
    //这里使用静态，让 service 属于类
    private static RoomService roomService;

    //注入的时候给service的类注入
    @Autowired
    public void setRoomService(RoomService roomService){
        FiveGameServer.roomService = roomService;
    }

    @OnOpen
    public void onopen(Session session, @PathParam("roomNumber") int roomNumber, @PathParam("u_id") String u_id, @PathParam("u_name") String u_name, EndpointConfig config) {

        String newU_name = u_name+";";
        roomService.joinWatching(roomNumber, newU_name);

    }

}


