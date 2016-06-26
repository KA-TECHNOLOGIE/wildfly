package fr.katechnologie.wildfly.websocket;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/valeurs")
public class ValeursEndpoint {

    private static final Logger logger = Logger.getLogger(ValeursEndpoint.class.getName());
    static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();


    public static void send(double valeur) {

        String message = String.format("%.2f", valeur);

        try {
            for (Session session : queue) {
                session.getBasicRemote().sendText(message);
                logger.log(Level.INFO, "Send: {0} ", message + " to " + session.getId());
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, e.toString());
        }
    }

    @OnOpen
    public void open(Session session) {
        queue.add(session);
    }

    @OnClose
    public void close(Session session) {
        queue.remove(session);
    }

    @OnError
    public void error(Session session, Throwable t) {
        queue.remove(session);
    }
}