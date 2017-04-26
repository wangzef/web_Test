package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbs.entity.Users;
import com.bbs.service.Usersservice;
import com.bbs.serviceImpl.UsersserviceImpl;

public class adminservlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("utf-8");
	    HttpSession session=request.getSession();
	    PrintWriter out = response.getWriter();
	    String act=request.getParameter("act");
	    if("login".equals(act)){
	    	String u_name=request.getParameter("adm");
	    	String u_pwd=request.getParameter("pwd");
	    	Usersservice uss=new UsersserviceImpl();
	    	Users u=new Users();
	    	u.setU_name(u_name);
	    	u.setU_pwd(u_pwd);
	    	int u_limits=2;
	    	if(uss.Loginservice(u,u_limits)){
	    		response.sendRedirect("aSchoolmain.jsp");
	    		session.setAttribute("users", u.getU_name());   //将登录信息存入session
	    		session.setAttribute("welcome", u.getU_name());
	    	}else{
	    		out.print("<script>alert('账号或密码错误！请重新输入');history.back();</script>");
	    	}
	    	
	    }
	    else if("out".equals(act)){
	    	session.invalidate();   //清空所有session'
	    	response.sendRedirect("index.jsp");
	    }
	    else if("main".equals(act)){
	    	response.sendRedirect("aSchoolmain.jsp");
	    }
	    
	}

}
