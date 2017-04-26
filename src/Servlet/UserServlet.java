package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbs.entity.Users;
import com.bbs.service.Usersservice;
import com.bbs.serviceImpl.UsersserviceImpl;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UserServlet extends HttpServlet {

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
		    	Usersservice uss=new UsersserviceImpl();
		    	String name=request.getParameter("name");
		    	String pwd=request.getParameter("pwd");
		    	Users users=new Users();
		    	users.setU_name(name);
		    	users.setU_pwd(pwd);
		    	int u_limits=1;
		    	if(uss.Loginservice(users,u_limits)){        //验证登录
		    		response.sendRedirect("Schoolmain.jsp");
		    		session.setAttribute("users", name);   //将登录信息存入session
		    		session.setAttribute("welcome", name);
		    	}else{
		    		out.print("<script>alert('账号或密码错误！请重新输入');history.back();</script>");
		    	}
		    }
		    else if("showusers".equals(act)){
		    	Usersservice uss=new UsersserviceImpl();
		    	List<Users> list=uss.showallusersservice();
		    	session.setAttribute("userinfo", list);
		    	response.sendRedirect("userinfo.jsp");
		    }
		    else if("close".equals(act)){
		    	int u_id=Integer.parseInt(request.getParameter("u_id"));
		    	int u_state=2;
		    	Usersservice uss=new UsersserviceImpl();
		    	uss.updateu_statebyu_idservice(u_id, u_state);
		    	session.removeAttribute("userinfo");
		    	response.sendRedirect("userinfo.jsp");
		    }
		    else if("open".equals(act)){
		    	int u_id=Integer.parseInt(request.getParameter("u_id"));
		    	int u_state=1;
		    	Usersservice uss=new UsersserviceImpl();
		    	uss.updateu_statebyu_idservice(u_id, u_state);
		    	session.removeAttribute("userinfo");
		    	response.sendRedirect("userinfo.jsp");
		    }
		    else if("personmsg".equals(act)){
		    	if(session.getAttribute("users")==null){
		    		out.print("<script>alert('请登录后查看资料');history.back();</script>");
		    		//response.sendRedirect("index.jsp");  //未登录转跳登录
		    	}else{
		    		String u_name=session.getAttribute("users").toString();
		    		Usersservice uss=new UsersserviceImpl();
		    		Users u=uss.selectusersbyu_nameservice(u_name);
		    		session.setAttribute("personmsg", u);
		    		response.sendRedirect("person.jsp"); 
		    	}
		    }
		    else if("changemsg".equals(act)){
		    	Usersservice uss=new UsersserviceImpl();
		    	String u_name=session.getAttribute("users").toString();  //获取名字
		    	Users u=uss.selectusersbyu_nameservice(u_name);  //根据名字获取用户详情
		    	
		    	SmartUpload su = new SmartUpload(); // 创建对象
				su.initialize(getServletConfig(), request, response); // 初始化
				su.setCharset("utf-8"); // 设置编码
				File file=null;
				String filePath=null;
				String photo=null;
				try {
					su.upload();
					file = su.getFiles().getFile(0); // 获取上传文件
					if(file.getFileName().trim().length()==0){     //如果用户未上传头像
						photo=u.getU_photo();   //头像不变
					}else{
						filePath = "upload/" + file.getFileName(); // 上传文件的路径
					    file.saveAs(filePath, SmartUpload.SAVE_VIRTUAL); // 上传文件
					    request.setAttribute("filePath", filePath);  
					    photo=request.getAttribute("filePath").toString();  //将图片路径存入数据库
					}
					
					String name=su.getRequest().getParameter("name");  
					String pwd=su.getRequest().getParameter("pwd");
					String sex=su.getRequest().getParameter("sex");
					String year=su.getRequest().getParameter("year");
					String major=su.getRequest().getParameter("major");
					
					if(uss.selectSameservice(name)){
						session.setAttribute("pwrong","用户名已存在");
						response.sendRedirect("person.jsp");  //用户名重复
					}else{
						uss.updatemsgby_nameservice(name, pwd, sex, major, year, photo, u_name);
						session.setAttribute("pwrong","");
						session.invalidate();
						response.sendRedirect("index.jsp");
					}
				} catch (SmartUploadException e) {
					e.printStackTrace();
				} // 准备上传
		    	
		    }
		    else if("showpmsg".equals(act)){
		    	Usersservice uss=new UsersserviceImpl();
		    	String name=request.getParameter("name");
				Users u=uss.selectusersbyu_nameservice(name);
				out.write("{\"flag\":\""+"专业："+u.getU_major()+"<br>性别："+u.getU_sex()+"<br>注册时间："+u.getU_regtime()+"<br>入学时间："+u.getU_year()+"\"}");
		    }
		
	}

}
