package com.cnpc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger( WebSocketUtils.class );
    public static final Map<String, Session> ONLINE_USER_SESSIONS = new ConcurrentHashMap<>();

    public static void sendMessage(Session session,String message){
        if(session == null){
            return;
        }
        final RemoteEndpoint.Basic basic = session.getBasicRemote();
        if(basic == null){
            return;
        }
        try {
            basic.sendText( message );
        } catch (IOException e) {
            LOGGER.error( "sendMessage IOException",e);
        }
    }

    public static void sendMessageAll(String message){
        ONLINE_USER_SESSIONS.forEach( (sessionid,session) -> sendMessage( session,message ) );
    }
}
