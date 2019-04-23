package controller;

import com.nf.Readme;
import com.nf.commons.MyUtils.Logging;
import com.nf.commons.MyUtils.Standard;
import com.nf.entities.Administrator;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping(value = "admin/goodsController")
public class GoodsController {


    Logging logging = new Logging();

    @Autowired
    IGoodsService goodsService;

    @ResponseBody
    @RequestMapping(value = "/selectAllGoodsCount", method = RequestMethod.POST)
    @Readme("查询所有商品总数的方法")
    public int selectAllGoodsCount(@RequestBody List<Object> mohuListLimit, HttpServletRequest request) {
        Administrator administrator = (Administrator) request.getSession().getAttribute("administrator");
        long start = System.currentTimeMillis();
        logging.setInfo("管理员：" + administrator.getAname() + "，开始执行：selectAllGoodsCount（查询所有商品总数的方法）");

        String startprice = "0.0";
        String endprice = "9999999.0";

        System.out.println("mohuListLimit:" + mohuListLimit);

        if (!(mohuListLimit.get(2) == "" || mohuListLimit.get(2).equals("") || mohuListLimit.get(2) == "0")) {
            startprice = (String) mohuListLimit.get(2);
        }
        if (!(mohuListLimit.get(3) == "" || mohuListLimit.get(3).equals("") || mohuListLimit.get(3) == "0")) {
            endprice = (String) mohuListLimit.get(3);
        }

        System.out.println(mohuListLimit);
        Map<String, Object> objectMap = new HashMap<>();

        objectMap.put("goodsname", mohuListLimit.get(0));
        objectMap.put("selectVal", mohuListLimit.get(1));
        objectMap.put("startprice", startprice);
        objectMap.put("endprice", endprice);
        if (mohuListLimit.get(4) != "" || !mohuListLimit.get(4).equals("")) {
            objectMap.put("trueGoodNo", mohuListLimit.get(4));
        }
        objectMap.put("pageno", 0);
        objectMap.put("pagesize", 9999999);
        objectMap.put("gstate", mohuListLimit.get(5).toString());

        Long span = System.currentTimeMillis() - start;
        logging.setInfo("管理员：" + administrator.getAname() + "，结束执行：selectAllGoodsCount（查询所有商品的方法）,共耗时：" + span + "毫秒");
        return goodsService.selectAllGoods(objectMap).size();
    }


    @ResponseBody
    @RequestMapping(value = "/selectAllGoods", method = RequestMethod.POST)
    public List<Goods> selectAllGoods(@RequestBody List<Object> objlist, HttpServletRequest request) {

        String startprice = "0.0";
        String endprice = "99999999.0";
        if (!(objlist.get(2) == "" || objlist.get(2).equals("") || objlist.get(2) == "0")) {
            startprice = (String) objlist.get(2);
        }
        if (!(objlist.get(3) == "" || objlist.get(3).equals("") || objlist.get(3) == "0")) {
            endprice = (String) objlist.get(3);
        }

        Map<String, Object> objectMap = new HashMap<>();

        int page = (int) objlist.get(4);
        int size = (int) objlist.get(5);
        int pageno = (page - 1) * size;
        objectMap.put("goodsname", objlist.get(0));
        objectMap.put("selectVal", objlist.get(1));
        objectMap.put("startprice", startprice);
        objectMap.put("endprice", endprice);

        /*
         * 单条查询
         * */
        if (objlist.get(6) != "" || !objlist.get(6).equals("")) {
            System.out.println("trueno:" + objlist.get(6));
            objectMap.put("trueGoodNo", objlist.get(6));
        }
        objectMap.put("gstate", objlist.get(7).toString());

        objectMap.put("pageno", pageno);
        objectMap.put("pagesize", size);

        return goodsService.selectAllGoods(objectMap);
    }

    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestBody List<Object> list, HttpServletRequest request) {

        Administrator administrator = (Administrator) request.getSession().getAttribute("administrator");
        long start = System.currentTimeMillis();
        logging.setInfo("管理员：" + administrator.getAname() + "，开始执行：insert（新增一条商品的方法）");

        // Set<String> rnm = new HashSet<String>();
        //  int n = 15;
        // for (int i = 0; i < n; i++) {
        /*随机生成商品编号*/
        Double random = Math.random();
        String str = random.toString().substring(2, 15);
        // rnm.add(str);
        //  }
        System.out.println("随机生成的14位商品编号是：" + str);
        System.out.println(list);
        Map<String, Object> objectMap = new HashMap<>();

        objectMap.put("gno", str);
        objectMap.put("gname", list.get(0).toString());
        objectMap.put("gcolor", list.get(1).toString());
        objectMap.put("gsize", list.get(2).toString());
        objectMap.put("gnowprice", list.get(3).toString());
        objectMap.put("gtdid", list.get(4).toString());
        objectMap.put("tid", list.get(5).toString());
        objectMap.put("gdesc", list.get(6).toString());
        objectMap.put("gpic", list.get(7).toString());
        objectMap.put("gstate", list.get(8).toString());

        Long span = System.currentTimeMillis() - start;
        logging.setInfo("管理员：" + administrator.getAname() + "，结束执行：insert（新增一条商品的方法）," +
                "新增的商品编号是："+str+",期间共耗时：" + span + "毫秒");
        if (goodsService.insert(objectMap) > 1) {
            return "success";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody List<Object> list,HttpServletRequest request) {

        Administrator administrator = (Administrator) request.getSession().getAttribute("administrator");

        long start = System.currentTimeMillis();
        logging.setInfo("管理员：" + administrator.getAname() + "，开始执行：update（修改一件商品的方法）");
        Map<String, Object> objectMap = new HashMap<>();

        objectMap.put("gname", list.get(0).toString());
        objectMap.put("gcolor", list.get(1).toString());
        objectMap.put("gsize", list.get(2).toString());
        objectMap.put("gnowprice", list.get(3).toString());
        objectMap.put("gtdid", list.get(4).toString());
        objectMap.put("tid", list.get(5).toString());
        objectMap.put("gdesc", list.get(6).toString());
        objectMap.put("gpic", list.get(7).toString());
        objectMap.put("gno", list.get(8).toString());
        objectMap.put("gstate", list.get(9).toString());
        objectMap.put("gid", list.get(10).toString());

        if (goodsService.update(objectMap) > 1) {
            Long span = System.currentTimeMillis() - start;
            logging.setInfo("管理员：" + administrator.getAname() + "，结束执行：update（修改一件商品的方法）," +
                    "被修改的商品编号是："+list.get(10).toString()+",期间共耗时：" + span + "毫秒");
            return "success";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @Readme("删除方法")
    public String delete(@RequestBody String goodno, HttpServletRequest request) {
        Administrator administrator = (Administrator) request.getSession().getAttribute("administrator");

        long start = System.currentTimeMillis();
        logging.setInfo("管理员：" + administrator.getAname() + "，开始执行：delete（删除一件商品的方法）");

        if (goodsService.delete(goodno) > 1) {
            Long span = System.currentTimeMillis() - start;
            logging.setInfo("管理员：" + administrator.getAname() + "，结束执行：delete（删除一件商品的方法）," +
                    "被删除的商品编号是："+goodno+",期间共耗时：" + span + "毫秒");
            return "success";
        }
        return "error";
    }

    /*
     * 文件上传
     *
     * */
    @RequestMapping(value = "/fileSave", method = RequestMethod.POST)
    @ResponseBody
    public Standard fileSave(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //文件存放的位置
        String path = request.getServletContext().getRealPath("/admin/img/goodsdetails");

        System.out.println(path);
        File fi = new File(path);
        if (!fi.exists()) {
            fi.mkdir();
        }
        File tempFile = new File(path, file.getOriginalFilename());
        file.transferTo(tempFile);
        System.out.println(tempFile.getName());
        Standard standard = new Standard();
        standard.put("msg", "上传成功!");
        standard.put("data", tempFile.getName());

        return standard;
    }


    @RequestMapping(value = "/exploreCsv", method = RequestMethod.GET)
    @ResponseBody
    public void joinXml(HttpServletResponse response) throws IOException {
        Map<String, Object> objectMap = new HashMap<>();
        String startprice = "0.0";
        String endprice = "9999999.0";
        int pageno = 0;
        int pagesize = 999999;
        objectMap.put("startprice", startprice);
        objectMap.put("endprice", endprice);
        objectMap.put("pageno", pageno);
        objectMap.put("pagesize", pagesize);

        //先获得所有数据
        List<Goods> goodsList = goodsService.selectAllGoods(objectMap);
        response.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("GoodsData".getBytes(), "UTF-8") + ".csv");
        PrintWriter out = response.getWriter();
        //加上bom头,解决excel打开乱码问题
        byte[] bomStrByteArr = new byte[]{(byte) 0xef, (byte) 0xbb, (byte) 0xbf};
        String bomStr = new String(bomStrByteArr, "UTF-8");
        out.write(bomStr);
        StringBuffer str = new StringBuffer("");
        //数据的来源
        str.append("产品编号,产品名称,产品价格,商品简介,产品类型\r\n");
        for (Goods item : goodsList) {
            System.out.println(item);
            str.append(item.getGid() + "," + item.getGname() + "," + item.getGnowprice() + "," + item.getGdesc() + ","
                    + item.getGoodsType().getTname() + "\r\n");
        }
        response.getWriter().write(str.toString());
    }
}
