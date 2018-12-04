package controller;

import com.nf.commons.MyUtils.Standard;
import com.nf.entities.Goods;
import com.nf.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping(value = "admin/goodsController")
public class GoodsController {

    @Autowired
    IGoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/selectAllGoodsCount",method = RequestMethod.POST)
    public int selectAllGoodsCount(@RequestBody List<Object> mohuListLimit){
        String startprice= "0.0";
        String endprice="99999999.0";

        System.out.println("mohuListLimit:"+mohuListLimit);

        if(!(mohuListLimit.get(2)==""||mohuListLimit.get(2).equals("")||mohuListLimit.get(2)=="0")){
            startprice= (String) mohuListLimit.get(2);
        }
        if(!(mohuListLimit.get(3)==""||mohuListLimit.get(3).equals("")||mohuListLimit.get(3)=="0")){
            endprice= (String) mohuListLimit.get(3);
        }

        System.out.println(mohuListLimit);
        Map<String,Object> objectMap=new HashMap<>();

        objectMap.put("goodsname",mohuListLimit.get(0));
        objectMap.put("selectVal",mohuListLimit.get(1));
        objectMap.put("startprice",startprice);
        objectMap.put("endprice",endprice);
        if(mohuListLimit.get(4)!=""||!mohuListLimit.get(4).equals("")) {
            objectMap.put("trueGoodNo", mohuListLimit.get(4));
        }
        objectMap.put("pageno",0);
        objectMap.put("pagesize",9999999);
        objectMap.put("gstate",mohuListLimit.get(5).toString());

       return goodsService.selectAllGoods(objectMap).size();
    }


    @ResponseBody
    @RequestMapping(value = "/selectAllGoods",method = RequestMethod.POST)
    public List<Goods> selectAllGoods(@RequestBody List<Object> objlist){

        String startprice= "0.0";
        String endprice="99999999.0";
        if(!(objlist.get(2)==""||objlist.get(2).equals("")||objlist.get(2)=="0")){
            startprice= (String) objlist.get(2);
        }
        if(!(objlist.get(3)==""||objlist.get(3).equals("")||objlist.get(3)=="0")){
            endprice= (String) objlist.get(3);
        }

        Map<String,Object> objectMap=new HashMap<>();

        int page= (int) objlist.get(4);
        int size= (int) objlist.get(5);
        int pageno=(page-1)*size;
        objectMap.put("goodsname",objlist.get(0));
        objectMap.put("selectVal",objlist.get(1));
        objectMap.put("startprice",startprice);
        objectMap.put("endprice",endprice);

        /*
        * 单条查询
        * */
        if(objlist.get(6)!=""||!objlist.get(6).equals("")) {
            System.out.println("trueno:"+objlist.get(6));
            objectMap.put("trueGoodNo", objlist.get(6));
        }
        objectMap.put("gstate",objlist.get(7).toString());

        objectMap.put("pageno",pageno);
        objectMap.put("pagesize",size);

        return goodsService.selectAllGoods(objectMap);
    }

    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@RequestBody List<Object> list){
       // Set<String> rnm = new HashSet<String>();
      //  int n = 15;
       // for (int i = 0; i < n; i++) {
        /*随机生成商品编号*/
        Double random = Math.random();
        String str = random.toString().substring(2, 15);
           // rnm.add(str);
      //  }
        System.out.println("随机生成的14位商品编号是："+str);
        System.out.println(list);
        Map<String,Object> objectMap=new HashMap<>();

        objectMap.put("gno",str);
        objectMap.put("gname",list.get(0).toString());
        objectMap.put("gcolor",list.get(1).toString());
        objectMap.put("gsize",list.get(2).toString());
        objectMap.put("gnowprice",list.get(3).toString());
        objectMap.put("gtdid",list.get(4).toString());
        objectMap.put("tid",list.get(5).toString());
        objectMap.put("gdesc",list.get(6).toString());
        objectMap.put("gpic",list.get(7).toString());
        objectMap.put("gstate",list.get(8).toString());
        if(goodsService.insert(objectMap)>1){
            return "success";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestBody List<Object> list){

        System.out.println(list);
        Map<String,Object> objectMap=new HashMap<>();

        objectMap.put("gname",list.get(0).toString());
        objectMap.put("gcolor",list.get(1).toString());
        objectMap.put("gsize",list.get(2).toString());
        objectMap.put("gnowprice",list.get(3).toString());
        objectMap.put("gtdid",list.get(4).toString());
        objectMap.put("tid",list.get(5).toString());
        objectMap.put("gdesc",list.get(6).toString());
        objectMap.put("gpic",list.get(7).toString());
        objectMap.put("gno",list.get(8).toString());
        objectMap.put("gstate",list.get(9).toString());
        objectMap.put("gid",list.get(10).toString());

        if(goodsService.update(objectMap)>1){
            return "success";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestBody String goodno ){

        System.out.println("goodno:"+goodno);

        if(goodsService.delete(goodno)>1){
            return "success";
        }
        return "error";
    }

    /*
     * 文件上传
     *
     * */
    @RequestMapping(value = "/fileSave",method = RequestMethod.POST)
    @ResponseBody
    public Standard fileSave(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //文件存放的位置
        String path=request.getServletContext().getRealPath("/admin/img/goodsdetails");
        File fi=new File(path);
        if(!fi.exists()){
            fi.mkdir();
        }
        File tempFile=new File(path, file.getOriginalFilename());
        file.transferTo(tempFile);
        System.out.println(tempFile.getName());
        Standard standard=new Standard();
        standard.put("msg","上传成功!");
        standard.put("data",tempFile.getName());

        return standard;
    }

}
