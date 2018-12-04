package controller;

import com.nf.commons.MyUtils.MD5Util;
import com.nf.commons.MyUtils.Standard;
import com.nf.entities.Administrator;
import com.nf.entities.Member;
import com.nf.service.IAdministratorService;
import com.nf.service.IMemberService;
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
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "admin/administratorController")
public class AdministratorController {

    @Autowired
    IAdministratorService administratorService;

    @ResponseBody
    @RequestMapping(value = "/selectAllAdministratorCount",method = RequestMethod.POST)
    public int selectAllAdministratorCount(@RequestBody List<Object> mohuListLimit){
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("pageno",0);
        objectMap.put("pagesize",99999);
        objectMap.put("astate",mohuListLimit.get(0).toString());
        objectMap.put("adept",mohuListLimit.get(1).toString());
        objectMap.put("aname",mohuListLimit.get(2).toString());
        objectMap.put("aphone",mohuListLimit.get(3).toString());
        return administratorService.selectAllAdministrator(objectMap).size();
    }

    @ResponseBody
    @RequestMapping(value = "/selectAllAdministrator",method = RequestMethod.POST)
    public List<Administrator> selectAllAdministrator(@RequestBody List<Object> objectList){
        Map<String,Object>objectMap=new HashMap<>();
        int page= (int) objectList.get(0);
        int size= (int) objectList.get(1);
        int pageno=(page-1)*size;
        objectMap.put("pageno",pageno);
        objectMap.put("pagesize",size);
        objectMap.put("astate",objectList.get(2).toString());
        objectMap.put("adept",objectList.get(3).toString());
        objectMap.put("aname",objectList.get(4).toString());
        objectMap.put("aphone",objectList.get(5).toString());
        return administratorService.selectAllAdministrator(objectMap);
    }

    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@RequestBody List<Object> objectList) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        System.out.println(objectList);
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("aname",objectList.get(0).toString());
        objectMap.put("aphone",objectList.get(1).toString());
        objectMap.put("adept",objectList.get(2).toString());
        objectMap.put("apassword",MD5Util.EncoderByMd5(objectList.get(3).toString()));
        objectMap.put("apic",objectList.get(4).toString());
        /*
        * 静态的数据
        * */
        objectMap.put("aregday",new Date().toLocaleString());
        objectMap.put("astate",0);
        if(administratorService.insert(objectMap)>0){
            return "success";
        }
         return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestBody  List<Object> objectList) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        System.out.println(objectList);

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("aname",objectList.get(0).toString());
        objectMap.put("aphone",objectList.get(1).toString());
        objectMap.put("adept",objectList.get(2).toString());
        objectMap.put("apassword",MD5Util.EncoderByMd5(objectList.get(3).toString()));
        objectMap.put("apic",objectList.get(4).toString());
        objectMap.put("aid",objectList.get(5).toString());

        if(administratorService.update(objectMap)>0){
            return "success";
        }
        return "error";
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestBody String mid){
        if(administratorService.delete(mid)>0){
            return "success";
        }
        return "error";
    }

   /*
   * 查询单个对象
   * */
   @RequestMapping(value = "/selectOneAdministrator",method = RequestMethod.POST)
   @ResponseBody
   public Administrator selectOneAdministrator(@RequestBody String aid){
       System.out.println(aid);
       return administratorService.selectOneAdministrator(aid);
   }

    /*
     * 文件上传
     *
     * */
    @RequestMapping(value = "/fileSave",method = RequestMethod.POST)
    @ResponseBody
    public Standard fileSave(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //文件存放的位置
        String path=request.getServletContext().getRealPath("/admin/img/adminpic");
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
