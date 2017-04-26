package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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


public class Regservlet extends HttpServlet {

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
		    Usersservice uss=new UsersserviceImpl();
		    String act=request.getParameter("act");
		    if("reg".equals(act)){
		    	SmartUpload su = new SmartUpload(); // 创建对象
				su.initialize(getServletConfig(), request, response); // 初始化
				su.setCharset("utf-8"); // 设置编码
				File file=null;
				String filePath=null;
				Users users=new Users();
				try {
					su.upload();
					file = su.getFiles().getFile(0); // 获取上传文件
					if(file.getFileName().trim().length()==0){     //如果用户未上传头像
						users.setU_photo("defphoto/a.jpg");   //默认头像
					}else{
						filePath = "upload/" + file.getFileName(); // 上传文件的路径
					    file.saveAs(filePath, SmartUpload.SAVE_VIRTUAL); // 上传文件
					    request.setAttribute("filePath", filePath);  
					    users.setU_photo(request.getAttribute("filePath").toString());  //将图片路径存入数据库
					}
					String name=su.getRequest().getParameter("username");  
					String pwd=su.getRequest().getParameter("password");
					String sex=su.getRequest().getParameter("sex");
					String date=su.getRequest().getParameter("date");
					String major=su.getRequest().getParameter("website");
					if(uss.selectSameservice(name)){
						response.sendRedirect("Reg.jsp");
					}else{
					Date dat=new Date();
					DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String time=format.format(dat);
					int state=1;
					users.setU_name(name);
					users.setU_pwd(pwd);
					users.setU_sex(sex);
					users.setU_regtime(time);
					users.setU_state(state);
					users.setU_major(major);
					users.setU_year(date);
					users.setU_limits(1);
					}
				} catch (SmartUploadException e) {
					e.printStackTrace();
				} // 准备上传
				uss.Regservice(users);
				response.sendRedirect("index.jsp");
		    }
		    else if("check".equals(act)){
		    	String username=request.getParameter("username");
				String result="";
				if(uss.selectSameservice(username)){
					result="用户名已存在";
				}else{
					result="";
				}
				out.write("{\"flag\":\""+result+"\"}");
		    }
	}

}
