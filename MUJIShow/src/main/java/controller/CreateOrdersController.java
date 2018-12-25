package controller;

import com.nf.entities.Orders;
import com.nf.service.ICreateOrdersService;
import com.nf.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "admin/createOrdersController")
public class CreateOrdersController {

    @Autowired
    ICreateOrdersService createOrdersService;

    @Autowired
    IOrdersService ordersService;

    @RequestMapping(value = "/selectCreateOrdersByPhone",method = RequestMethod.POST)
    @ResponseBody
    public void selectCreateOrdersByPhone(@RequestBody List<Object> objectList){

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("mphone",objectList.get(0).toString());
        objectMap.put("costatus",objectList.get(1).toString());
        createOrdersService.selectCreateOrdersByPhone(objectMap);
    }

    @RequestMapping(value = "/initOneCreateOrders",method = RequestMethod.POST)
    @ResponseBody
    public String initOneCreateOrders(@RequestBody List<Orders>objectList, HttpServletRequest request){
        List<Orders> objects= (List<Orders>) objectList.get(0);
        for (int i=0;i<objects.size();i++){
            System.out.println(objects.get(i).getMphone());
            System.out.println(objects.get(i).getGid());
            System.out.println(objects.get(i).getOcount());
            System.out.println(objects.get(i).getOsumprice());
        }
        /*
        * 随机生成订单号
        * */
        String sysdate= String.valueOf(System.currentTimeMillis());
        String cono=sysdate.substring(0,sysdate.length()-1);

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("cono",cono);
        objectMap.put("cordesc","");
       // if (createOrdersService.initOneCreateOrders(objectMap)>0){
       //    return "success";


            /*
            * 把商品添加到orders表
            * */
            //Map<String,Object>objectMap1=new HashMap<>();
           // ordersService.insert(objectMap1);


       // }
        return "";
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
}
