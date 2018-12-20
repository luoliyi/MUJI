package controller;

import com.mysql.cj.Session;
import com.nf.entities.Member;
import com.nf.entities.ShoppingCart;
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

/*
* 该控制器主要用于：
* 1、加入购物车的操作
* 2、订单的操作
* 3、购物车增删改查的操作
*
* */

@Controller
@RequestMapping(value = "shoppingCarController")
public class ShoppingCarController {

    @Autowired
    IShoppingCartService shoppingCartService;

    /*
    * 用户信息
    * */
    Member member=null;

    @RequestMapping(value = "/selectAllCartsByMphone",method = RequestMethod.POST)
    @ResponseBody
    public List<ShoppingCart> selectAllCartsByMphone(HttpServletRequest request){
        /*
         * 从session获取用户信息
         * */
        HttpSession session=request.getSession();
        member= (Member) session.getAttribute("member");
        System.out.println("member的信息如下：");
        System.out.println(member);

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("mphone",member.getMphone());
        return shoppingCartService.selectAllCartByMphone(objectMap);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody List<Object> objectList, HttpServletRequest request){

        HttpSession session=request.getSession();
        member= (Member) session.getAttribute("member");

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("mphone",member.getMphone());
        objectMap.put("gid",objectList.get(0).toString());
        objectMap.put("sccount",objectList.get(1).toString());
        objectMap.put("sumprice",objectList.get(2).toString());
        objectMap.put("sctate",0);
        if (shoppingCartService.insert(objectMap)>0) {
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestBody List<Object> objectList){
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("scid",objectList.get(0).toString());
        if (shoppingCartService.delete(objectMap)>0) {
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody List<Object> objectList){
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("sccount",objectList.get(0).toString());
        objectMap.put("sumprice",objectList.get(1).toString());
        objectMap.put("scid",objectList.get(2).toString());
        if (shoppingCartService.update(objectMap)>0) {
            return "success";
        }
        return "error";
    }


    /*
    * 减数量
    * */
    @RequestMapping(value = "/delCount",method = RequestMethod.POST)
    @ResponseBody
    public List<ShoppingCart> delCount(@RequestBody List<Object>objectList){
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("sccount",objectList.get(0).toString());
        objectMap.put("scid",objectList.get(1).toString());
        if(shoppingCartService.delCount(objectMap)>0){
            Map<String,Object>objectMap1=new HashMap<>();
            objectMap1.put("mphone",member.getMphone());
            return shoppingCartService.selectAllCartByMphone(objectMap1);
        }
        return null;
    }

    /*
     * 加数量
     * */
    @RequestMapping(value = "/addCount",method = RequestMethod.POST)
    @ResponseBody
    public List<ShoppingCart> addCount(@RequestBody List<Object>objectList){
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("sccount",objectList.get(0).toString());
        objectMap.put("scid",objectList.get(1).toString());
        if(shoppingCartService.addCount(objectMap)>0){
            Map<String,Object>objectMap1=new HashMap<>();
            objectMap1.put("mphone",member.getMphone());
            return shoppingCartService.selectAllCartByMphone(objectMap1);
        }
        return null;
    }

}
