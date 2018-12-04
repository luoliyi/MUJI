package controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private List<String> exceptUrls;
    public List<String> getExceptUrls() {
        return exceptUrls;
    }
    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }

    //执行action之前来执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri=request.getRequestURI();
        if(requestUri.startsWith(request.getContextPath())){
            requestUri = requestUri.substring(request.getContextPath().length(), requestUri.length());
            System.out.println("requestUri:"+requestUri);
        }

        //系统根目录
        if (StringUtils.equals("/",requestUri)) {
            return true;
        }

        //放行exceptUrls中配置的url
        for (String url:exceptUrls) {
            if(url.endsWith("/**")){
                if (requestUri.startsWith(url.substring(0, url.length() - 3))) {
                    return true;
                }
            } else if (requestUri.startsWith(url)) {
                return true;
            }
        }

        //其他需要登录后才能进行访问的url
        //String sessionid = request.getSession().getId();
        //在这里我们可以定义一个session来存储登录状态
        //如果没有登录
        //HttpSession session=request.getSession();
        Object status=request.getSession().getAttribute("loginSuccess");
       //String status="";
        System.out.println("status:"+status);
        if(status=="loginSuccess"){
            return true;
        }else{
            //返回到登录页面
            response.sendRedirect("/admin/login.html");
            return false;
        }
    }
}

