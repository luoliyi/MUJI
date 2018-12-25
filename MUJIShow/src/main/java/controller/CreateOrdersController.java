package controller;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/initOneCreateOrders",method = RequestMethod.POST)
    @ResponseBody
    public String initOneCreateOrders( HttpServletRequest request){

        HttpSession session=request.getSession();
        member= (Member) session.getAttribute("member");
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("mphone",member.getMphone());
        List<ShoppingCart>shoppingCarts=shoppingCartService.selectAllCartByMphone(objectMap);

        /*
        * 随机生成订单号
        * */
        String sysdate= String.valueOf(System.currentTimeMillis());
        String cono=sysdate.substring(0,sysdate.length()-1);

        Map<String,Object>objectMap1=new HashMap<>();
        objectMap.put("cono",cono);
        objectMap.put("cordesc","");
        if (createOrdersService.initOneCreateOrders(objectMap)>0){
            /*
            * 把商品添加到orders表
            * */
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
                /*
                 * 删除购物车
                 * */
                ordersService.delete(objectMap3);
            }
            if (result>0){
                return "success";
            }
        }
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
