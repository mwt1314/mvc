package cn.dgkj.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mawt
 * <p>
 * JSR356定义了WebSocket的规范，Tomcat7中实现了该标准。JSR356 的 WebSocket 规范使用 javax.websocket.*的 API，可以将一个普通 Java 对象（POJO）使用 ,
 * @ServerEndpoint 注释作为 WebSocket 服务器的端点。
 */
@ServerEndpoint("/ws/{username}")
public class WebSocketEchoEndpoint {

    private static Map<String, WebSocketEchoEndpoint> clients = new ConcurrentHashMap<String, WebSocketEchoEndpoint>();

    private String username;

    private Session session;

    private static int onlineCount = 0;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        this.username = username;
        this.session = session;

        addOnlineCount();
        clients.put(username, this);
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
       /* JSONObject jsonTo = JSONObject.fromObject(message);
        String mes = (String) jsonTo.get("message");
        if (!jsonTo.get("To").equals("All")) {
            sendMessageTo(mes, jsonTo.get("To").toString());
        } else {
            sendMessageAll("给所有人");
        }*/
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        clients.remove(username);
        subOnlineCount();
    }

    public void sendMessageTo(String message, String To) throws IOException {
        // session.getBasicRemote().sendText(message);
        //session.getAsyncRemote().sendText(message);

        for (WebSocketEchoEndpoint item : clients.values()) {
            if (item.username.equals(To)) {
                item.session.getAsyncRemote().sendText(message);
            }
        }
    }

    public void sendMessageAll(String message) throws IOException {
        for (WebSocketEchoEndpoint item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketEchoEndpoint.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketEchoEndpoint.onlineCount--;
    }

    public static synchronized Map<String, WebSocketEchoEndpoint> getClients() {
        return clients;
    }

}
