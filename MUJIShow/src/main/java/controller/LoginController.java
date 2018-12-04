package controller;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(value = "admin/loginController")
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public void login(@RequestBody List<String> loginList, HttpServletRequest request, HttpServletResponse response) throws IOException {


        System.out.println(loginList.get(0)+","+loginList.get(1));

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
        if(loginList.get(0).equals("13926901501")&&loginList.get(1).equals("123456")){
            HttpSession session=request.getSession();
            session.setAttribute("loginSuccess","loginSuccess");
            System.out.println("登录成功");
            response.getWriter().print("登录成功");
        }else {
            response.getWriter().print("登录失败");
        }
    }
}
