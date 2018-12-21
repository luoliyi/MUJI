package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Servlet implementation class test
 */
@WebServlet("/getIp")
public class GetIp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	    public static String getIpAddr(HttpServletRequest request,HttpServletResponse response) {  
	    	
	    	try {
				request.setCharacterEncoding("utf-8");
		    	response.setContentType("text/html;charset=utf-8");
		    	response.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

	    	
	        String ipAddress = request.getHeader("x-forwarded-for");
	        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("Proxy-Client-IP");
	        }
	        if (ipAddress == null || ipAddress.length() == 0 || "unknow".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getRemoteAddr();
	            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){

	                InetAddress inetAddress = null;
	                try {
	                    inetAddress = InetAddress.getLocalHost();
	                } catch (UnknownHostException e) {
	                    e.printStackTrace();
	                }
	                ipAddress = inetAddress.getHostAddress();
	            }
	        }

	        if(null != ipAddress && ipAddress.length() > 15){
	            //"***.***.***.***".length() = 15
	            if(ipAddress.indexOf(",") > 0){
	                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
	            }
	        }
	        System.out.println(ipAddress);
	        try {
				response.getWriter().print("{\"ip\":\""+ipAddress+"\"}");
			} catch (IOException e) {
				e.printStackTrace();
			}
	        return ipAddress;
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getIpAddr(request,response);
	}

}
