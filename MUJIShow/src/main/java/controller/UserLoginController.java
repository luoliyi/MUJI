package controller;

import com.nf.commons.MyUtils.MD5Util;
import com.nf.entities.Administrator;
import com.nf.entities.Member;
import com.nf.entities.Sales;
import com.nf.service.IAdministratorService;
import com.nf.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.nio.cs.ext.MacArabic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "userloginController")
public class UserLoginController {


    @Autowired
    IMemberService memberService;

    Member member=null;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public void login(@RequestBody List<String> loginList, HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {


        String logId=loginList.get(0);
        String pass=loginList.get(1);

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("mphone",logId);
        objectMap.put("mpassword",MD5Util.EncoderByMd5(pass));

        member=memberService.selectOne(objectMap);
        /*
        * 这里别设置返回类型，否则
        * {readyState: 4, getResponseHeader: ƒ, getAllResponseHeaders: ƒ, setRequestHeader: ƒ, overrideMimeType}
        * */
        response.setCharacterEncoding("utf-8");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /*
        * 获得登录的账号和密码
        * */
        if(member!=null){
            HttpSession session=request.getSession();
            /*
            * 保存在session中去
            * */
            session.setAttribute("member",member);
            System.out.println("登录成功，欢迎您："+member.getMname());
            response.getWriter().print("success");
        }else {
            response.getWriter().print("error");
        }
    }

    /*
    * 返回用户的信息
    * */
    @RequestMapping(value = "/getMemberInfo",method = RequestMethod.POST)
    @ResponseBody
    public Member getMemberInfo(){
        System.out.println("come in!");
        if(member!=null){
            return member;
        }
        return null;
    }

    /*
    * 短信登录
    * */
    @RequestMapping(value = "/shortMessageLogin",method = RequestMethod.POST)
    @ResponseBody
    public void shortMessageLogin(@RequestBody List<String> loginList, HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {

        String logId = loginList.get(0);

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("mphone", logId);
        member = memberService.selectOne(objectMap);
        /*
         * 这里别设置返回类型，否则
         * {readyState: 4, getResponseHeader: ƒ, getAllResponseHeaders: ƒ, setRequestHeader: ƒ, overrideMimeType}
         * */
        response.setCharacterEncoding("utf-8");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(member!=null){
            HttpSession session=request.getSession();
            /*
             * 保存在session中去
             * */
            session.setAttribute("member",member);
            System.out.println("登录成功，欢迎您："+member.getMname());
            response.getWriter().print("success");
        }else {
            response.getWriter().print("error");
        }
    }

    /*
     * 注册
     * */
    @RequestMapping(value = "/regsister",method = RequestMethod.POST)
    @ResponseBody
    public String regsister(@RequestBody List<Object>objects,HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String oPhone=objects.get(0).toString();
        String oPwd=objects.get(1).toString();
        /*
         * 注册前先判断是否有该手机号码
         * */
        Map<String,Object>objectMap1=new HashMap<>();
        objectMap1.put("mphone",oPhone);
        Member m=memberService.selectOne(objectMap1);
        if (m!=null){
            return "error";
        }else {
            try {
                Map<String,Object>objectMap2=new HashMap<>();
                objectMap2.put("mphone",oPhone);
                objectMap2.put("mpassword",MD5Util.EncoderByMd5(oPwd));
                int r=memberService.regsister(objectMap2);
                if (r>0){
                    return oPhone;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
