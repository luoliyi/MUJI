package controller;

import com.nf.commons.MyUtils.MD5Util;
import com.nf.commons.MyUtils.Standard;
import com.nf.entities.Administrator;
import com.nf.entities.HistoryOrdersDiary;
import com.nf.service.IAdministratorService;
import com.nf.service.IHistoryOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "admin/historyOrdersController")
public class HistoryOrdersController {

    @Autowired
    IHistoryOrdersService historyOrdersService;


    /*
    *
    * 数据迁移之前先查询出当前的条数是多少
    * */

    @ResponseBody
    @RequestMapping(value = "/selectCount",method = RequestMethod.POST)
    public int selectCount(){
        return historyOrdersService.selectCount();
    }


    /*
     * 查询记录表总数
     * */
    @ResponseBody
    @RequestMapping(value = "/selectHistoryOrdersDiaryCount",method = RequestMethod.POST)
    public int selectHistoryOrdersDiaryCount(){
        return historyOrdersService.selectHistoryOrdersDiaryCount();
    }


    /*
    * 查询记录表
    * */
    @ResponseBody
    @RequestMapping(value = "/selectHistoryOrdersDiary",method = RequestMethod.POST)
    public List<HistoryOrdersDiary>selectHistoryOrdersDiary(@RequestBody List<Object>objectList){

        Map<String,Object>objectMap=new HashMap<>();
        int page=(int)objectList.get(0);
        int pagesize=(int)objectList.get(1);
        int pageno=(page-1)*pagesize;
        objectMap.put("pageno",pageno);
        objectMap.put("pagesize",pagesize);

        return historyOrdersService.selectHistoryOrdersDiary(objectMap);
    }

    /*
    * 开始数据迁移
    * */
    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(@RequestBody List<Object>objects,HttpServletRequest request){

        Map<String,Object>objectMap=new HashMap<>();

        int movecount=historyOrdersService.insert(objectMap);
        /*
        * 如果迁移成功
        * */
        if(movecount>0){

            HttpSession session=request.getSession();
            Administrator administrator= (Administrator) session.getAttribute("administrator");
            System.out.println(administrator);
            Map<String,Object>adminObj=new HashMap<>();
            adminObj.put("movetime",new Date().toLocaleString());
            adminObj.put("movecount",movecount);
            adminObj.put("movestatus","0");
            adminObj.put("movepeople",administrator.getAname());

            /*
            * 插入迁移记录
            * */
           if (historyOrdersService.insertOrdersDiary(adminObj)>0){
               /*
               * 删除历史数据
               * */
               if (historyOrdersService.delete()>0){
                   return movecount;
               }
           }

        }
        return 0;
    }

}
