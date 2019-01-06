package controller;

import com.nf.commons.MyUtils.PrintPdf;
import com.nf.dao.test.Commodity2;
import com.nf.dao.test.TestPrinter;
import com.nf.entities.CreateOrders;
import com.nf.entities.Member;
import com.nf.entities.Orders;
import com.nf.entities.ShoppingCart;
import com.nf.service.ICreateOrdersService;
import com.nf.service.IOrdersService;
import com.nf.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "admin/createOrdersController")
public class CreateOrdersController {

    @Autowired
    ICreateOrdersService createOrdersService;

    @Autowired
    IOrdersService ordersService;

    @Autowired
    IShoppingCartService shoppingCartService;

    @RequestMapping(value = "/selectCreateOrdersByPhone",method = RequestMethod.POST)
    @ResponseBody
    public void selectCreateOrdersByPhone(@RequestBody List<Object> objectList){

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("mphone",objectList.get(0).toString());
        objectMap.put("costatus",objectList.get(1).toString());
        createOrdersService.selectCreateOrdersByPhone(objectMap);
    }

    Member member=null;

    String threeMin="";
    String mycono="";

    @RequestMapping(value = "/initOneCreateOrders",method = RequestMethod.POST)
    @ResponseBody
    public String initOneCreateOrders(HttpServletRequest request){

        Long time = System.currentTimeMillis();//获得系统当前时间的毫秒数
        System.out.println("获取当前系统时间为："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time));//转换成标准年月日的形式
        Date date = new Date(time);
       // time +=30*1000*60;//在当前系统时间的基础上往后加30分钟
        time +=30*1000*60;
        threeMin=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        System.out.println(threeMin);

        HttpSession session=request.getSession();
        member= (Member) session.getAttribute("member");
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("mphone",member.getMphone());
        List<ShoppingCart>shoppingCarts=shoppingCartService.selectAllCartByMphone(objectMap);
        String sysdate= String.valueOf(System.currentTimeMillis());
        String cono=sysdate.substring(0,sysdate.length()-1);

        mycono = cono;
        Map<String,Object>objectMap1=new HashMap<>();
        objectMap.put("cono",cono);
        objectMap.put("cordesc","");
        if (createOrdersService.initOneCreateOrders(objectMap)>0){

            int result=0;
            for (ShoppingCart shoppingCart:shoppingCarts){

                Map<String,Object>objectMap2=new HashMap<>();
                objectMap2.put("mphone",member.getMphone());
                objectMap2.put("gid",shoppingCart.getGid());
                objectMap2.put("ocount",shoppingCart.getSccount());
                objectMap2.put("osumprice",shoppingCart.getSumprice());
                objectMap2.put("cono",cono);

                Map<String,Object>objectMap3=new HashMap<>();
                objectMap3.put("scid",shoppingCart.getScid());
                result+=ordersService.insert(objectMap2);

                ordersService.delete(objectMap3);
            }
            if (result>0){
                return threeMin;
            }
        }
        System.out.println(threeMin);
        return threeMin;
    }

    @RequestMapping(value = "/updatePendingReceiptByCono",method = RequestMethod.POST)
    @ResponseBody
    public void updatePendingReceiptByCono(String cono){
        createOrdersService.updatePendingReceiptByCono(cono);
    }

    @RequestMapping(value = "/updateCompletedByCono",method = RequestMethod.POST)
    @ResponseBody
    public void updateCompletedByCono(String cono){
        createOrdersService.updateCompletedByCono(cono);
    }

    @RequestMapping(value = "/updateAfterSaleByCono",method = RequestMethod.POST)
    @ResponseBody
    public void updateAfterSaleByCono(String cono){
        createOrdersService.updateAfterSaleByCono(cono);
    }

    @RequestMapping(value = "/selectAllOrderByMphoneAndStateAndLimit",method = RequestMethod.POST)
    @ResponseBody
    public List<CreateOrders> selectAllOrderByMphoneAndStateAndLimit(@RequestBody List<Object>objects, HttpServletRequest request){

        /*
        * 计算时间
        * */
        calcluateConoTime();
        Member member= (Member) request.getSession().getAttribute("member");
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("mphone",member.getMphone());
        objectMap.put("ostate",objects.get(0).toString());
        objectMap.put("cono",objects.get(1).toString().equals("")?"":mycono);
        objectMap.put("paystatus",objects.get(2).toString());
        return createOrdersService.selectAllOrderByMphoneAndStateAndLimit(objectMap);
    }

    @RequestMapping(value = "/cancelCreateOrder",method = RequestMethod.POST)
    @ResponseBody
    public String cancelCreateOrder(){
        return doCancelOrder();
    }

    public void calcluateConoTime(){
        System.out.println("订单时间："+threeMin);
        Long time = System.currentTimeMillis();//获得系统当前时间的毫秒数
        System.out.println("系统时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time));//转换成标准年月日的形式
        String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);

        int res=threeMin.compareTo(nowTime);
        if(res>0) {
            System.out.println("str1>str2");
        }
        else if(res==0) {
            System.out.println("str1=str2");
        }
        else{
            System.out.println("str1<str2");
            /*
            * 时间已过
            * */
            doCancelOrder();
        }
    }

    public String doCancelOrder(){
        if(createOrdersService.cancelOrders(mycono)>0){
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/getMyCono",method = RequestMethod.POST)
    @ResponseBody
    public String getMycono(){
        StringBuffer myConoInfo=new StringBuffer();
        if(!mycono.equals("")){
            System.out.println(mycono);
            myConoInfo.append(mycono);
            int sumprice=createOrdersService.selectSumPriceByCono(mycono);
            myConoInfo.append(","+sumprice);
            return myConoInfo.toString();
        }
        return null;
    }

    /*
    * 修改订单状态
    * */
    @RequestMapping(value = "/ordersSuccessPay",method = RequestMethod.POST)
    @ResponseBody
    public String ordersSuccessPay(HttpServletRequest request){
        String cono=request.getParameter("cono");
        if(createOrdersService.ordersSuccessPay(cono)>0){
            return "success";
        }
        return "error";
    }

    /*
     * 检查订单状态
     * */
    @RequestMapping(value = "/checkOrderPayStatus",method = RequestMethod.POST)
    @ResponseBody
    public String checkOrderPayStatus(){
       return createOrdersService.checkOrderPayStatus(mycono);
    }


    /*
     * 查询所有订单状态总数
     * */
    @RequestMapping(value = "/backgroundSelectAllOrdersCount",method = RequestMethod.POST)
    @ResponseBody
    public int backgroundSelectAllOrdersCount(){

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("pageno",0);
        objectMap.put("pagesize",999999);
        return createOrdersService.backgroundSelectAllOrders(objectMap).size();
    }

    /*
    * 查询所有订单状态
    * */
    @RequestMapping(value = "/backgroundSelectAllOrders",method = RequestMethod.POST)
    @ResponseBody
    public List<CreateOrders> backgroundSelectAllOrders(@RequestBody List<Object>objlist){
        int page= (int) objlist.get(0);

        int pagesize= (int) objlist.get(1);
        int pageno=(page-1)*pagesize;

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("pageno",pageno);
        objectMap.put("pagesize",pagesize);
        objectMap.put("cono",objlist.get(2).toString());
        return createOrdersService.backgroundSelectAllOrders(objectMap);
    }

    /*
     * 修改订单状态
     * */
    @RequestMapping(value = "/backgroundUpdateConoStatus",method = RequestMethod.POST)
    @ResponseBody
    public String backgroundUpdateConoStatus(@RequestBody List<Object>objlist){

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("costatus",objlist.get(0).toString());
        objectMap.put("cono",objlist.get(1).toString());

        if (createOrdersService.backgroundUpdateConoStatus(objectMap)>0){
            return "success";
        }
        return "error";
    }


    /*
    * 打印订单
    * */
    @RequestMapping(value = "/printPdf",method = RequestMethod.POST)
    @ResponseBody
    public String printPdf(@RequestBody List<Object>objlist){
        Map<String ,Object>objectMap=new HashMap<>();
        objectMap.put("cono",objlist.get(0).toString());
        List<Orders> ordersList=ordersService.selectAllGoodsByCono(objectMap);

        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pageFormat = job.defaultPage();//得到默认页格式
        ArrayList<Orders> arrayList=new ArrayList<>();
        for(int i=0;i<ordersList.size();i++){
            arrayList.add(ordersList.get(i));
        }
        job.setPrintable(new PrintPdf(arrayList));//设置打印类
        try {
            //可以用printDialog显示打印对话框，在用户确认后打印；也可以直接打印
            boolean a=job.printDialog();
            if(a){
                job.print();
            } else{
                job.cancel();
            }
        } catch (PrinterException e) {
            e.printStackTrace();
        }
        return "";
    }
}
