package controller;

import com.nf.entities.Goods;
import com.nf.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/mainController")
public class MainController {

    @Autowired
    IGoodsService goodsService;

    @RequestMapping(value = "/getNewGoods",method = RequestMethod.POST)
    @ResponseBody
    public List<Goods> getNewGoods(){

        Map<String,Object>objectMap=new HashMap<>();

        objectMap.put("pageno",0);
        objectMap.put("pagesize",6);
        return goodsService.selectNewGoods(objectMap);
    }

    @RequestMapping(value = "/getOneGood",method = RequestMethod.POST)
    @ResponseBody
    public Goods getOneGood(@RequestBody Integer gid){

        System.out.println(gid);

        return goodsService.selectOneGood(gid);
    }

}
