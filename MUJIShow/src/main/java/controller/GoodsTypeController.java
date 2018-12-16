package controller;

import com.nf.commons.MyUtils.Standard;
import com.nf.entities.Goods;
import com.nf.entities.GoodsType;
import com.nf.entities.GoodsTypeDetails;
import com.nf.service.IGoodsService;
import com.nf.service.IGoodsTypeDetailsService;
import com.nf.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "goodsTypeController")
public class GoodsTypeController {

    /*
    * 类型
    * */
    @Autowired
    IGoodsTypeService goodsTypeService;

    /*
    * 类型详细
    * */
    @Autowired
    IGoodsTypeDetailsService goodsTypeDetailsService;


    @RequestMapping(value = "/selectAllGoodsTypeDetailsByTid",method = RequestMethod.POST)
    @ResponseBody
    public List<GoodsType> selectAllGoodsTypeDetailsByTid(@RequestBody List<Object> objectList){
        Map<String,Object>objectMap=new HashMap<>();
        String tid=objectList.get(0).toString();
        objectMap.put("tid",tid);
       return goodsTypeService.selectAllGoodsTypeDetailsByTid(objectMap);
    }

    @RequestMapping(value = "/selectAllGoodsTypeDetailsByGtdid",method = RequestMethod.POST)
    @ResponseBody
    public List<GoodsTypeDetails> selectAllGoodsTypeDetailsByGtdid(@RequestBody List<Object> objectList){
        Map<String,Object>objectMap=new HashMap<>();
        String gtdid=objectList.get(0).toString();
        objectMap.put("gtdid",gtdid);
        return goodsTypeDetailsService.selectAllGoodsTypeDetailsByGtdid(objectMap);
    }

    @RequestMapping(value = "/initSelectAllGoodsTypeDetailsByTid",method = RequestMethod.POST)
    @ResponseBody
    public List<GoodsTypeDetails> initSelectAllGoodsTypeDetailsByTid(@RequestBody List<Object> objectList){
        Map<String,Object>objectMap=new HashMap<>();
        String tid=objectList.get(0).toString();
        objectMap.put("tid",tid);
        return goodsTypeDetailsService.selectAllGoodsTypeDetailsByGtdid(objectMap);
    }

}
