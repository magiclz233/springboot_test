package com.cnpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import static com.cnpc.util.WebSocketUtils.ONLINE_USER_SESSIONS;
import static com.cnpc.util.WebSocketUtils.sendMessageAll;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@RestController
@ServerEndpoint( "/chat-room/{username}" )
public class ChatRoomServerEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger( ChatRoomServerEndpoint.class );

    @OnOpen
    public void openSession(@PathParam( "username" ) String username, Session session){
        ONLINE_USER_SESSIONS.put( username,session );
        String message = "欢迎用户[" + username + "] 来到聊天室！";
        LOGGER.info("用户登录："+message);
        sendMessageAll(message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        LOGGER.info("发送消息："+message);
        sendMessageAll("用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        //当前的Session 移除
        ONLINE_USER_SESSIONS.remove(username);
        //并且通知其他人当前用户已经离开聊天室了
        sendMessageAll("用户[" + username + "] 已经离开聊天室了！");
        try {
            session.close();
        } catch (IOException e) {
            LOGGER.error("onClose error",e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            LOGGER.error("onError excepiton",e);
        }
        LOGGER.info("Throwable msg "+throwable.getMessage());
    }

}
