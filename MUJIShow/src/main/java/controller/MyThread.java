package controller;

import com.nf.daoImpl.IOrdersDaoImpl;

public class MyThread implements Runnable{

    /*@Autowired
    IAdministratorService administratorService;*/
    /*
    * 线程无法使用spring ioc注入
    * */

    private int sum;
    private int new_sum;
    private boolean stopMe = true;
    public void stopMe() {
        stopMe = false;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run()  {
        /*
        * 线程注入：java.lang.NullPointerException
        * */
        IOrdersDaoImpl ordersDao =new IOrdersDaoImpl();
        sum=ordersDao.allOrdersCountMonitor();
        System.out.println("sum："+sum);
        WebsocketController wbs=new WebsocketController();
        while(stopMe){
            new_sum=ordersDao.allOrdersCountMonitor();
            if(sum!=new_sum){
                System.out.println("change");
                sum=new_sum;
                wbs.onMessage(sum);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//        websocket = new WebSocket("ws://localhost:8081/websocketController");
// 注意此处的ws要加上项目名JavaWebSocket再加@ServerEndpoint注解的值websocket