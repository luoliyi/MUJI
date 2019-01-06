package controller;

import com.nf.impl.IAdministratorImpl;
import com.nf.service.IAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint( value = "/websocketController")
public class WebsocketController {

    MyThread thread1=new MyThread();
    Thread thread=new Thread(thread1);

    //用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebsocketController> webSocketSet = new CopyOnWriteArraySet<WebsocketController>();
    private  javax.websocket.Session session=null;

    /**
     * @ClassName: onOpen
     * @Description: 开启连接的操作
     */
    @OnOpen
    public void onOpen(Session session) throws IOException{
        this.session=session;
        webSocketSet.add(this);
        System.out.println(webSocketSet);

        //开启一个线程对数据库中的数据进行轮询
        thread.start();
    }

    /**
     * @ClassName: onClose
     * @Description: 连接关闭的操作
     */
    @OnClose
    public void onClose(){
        thread1.stopMe();
        webSocketSet.remove(this);
    }

    /**
     * @ClassName: onMessage
     * @Description: 给服务器发送消息告知数据库发生变化
     */
    @OnMessage
    public void onMessage(int count) {
        System.out.println("发生变化"+count);
        try {
            sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @ClassName: OnError
     * @Description: 出错的操作
     */
    @OnError
    public void onError(Throwable error){
        System.out.println(error);
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @throws IOException
     * 发送自定义信号，“1”表示告诉前台，数据库发生改变了，需要刷新
     */
    public void sendMessage() throws IOException{
        //群发消息
        for(WebsocketController item: webSocketSet){
            item.session.getBasicRemote().sendText("1");
        }
    }
}
