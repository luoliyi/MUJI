package controller;

import com.nf.commons.MyUtils.MD5Util;
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
}
