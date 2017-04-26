package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbs.entity.Diss;
import com.bbs.entity.Posts;
import com.bbs.entity.Typ;
import com.bbs.entity.Users;
import com.bbs.service.Dissservice;
import com.bbs.service.Postsservice;
import com.bbs.service.Typservice;
import com.bbs.service.Usersservice;
import com.bbs.serviceImpl.DissserviceImpl;
import com.bbs.serviceImpl.PostsserviceImpl;
import com.bbs.serviceImpl.TypserviceImpl;
import com.bbs.serviceImpl.UsersserviceImpl;

public class aPostservlet extends HttpServlet {

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
		    String act=request.getParameter("act");
		    if("showMRCB".equals(act)){ 					//��ʾÿ�ճ���
		    	Postsservice pss=new PostsserviceImpl();
		    	Typservice ts=new TypserviceImpl();
		    	List<Posts> list1=pss.showpostsbyt_idservice(1);
		    	session.setAttribute("MRCB", list1);  
		    	List<Posts> list2=pss.showpostsbyt_idservice(2);
		    	session.setAttribute("XYQW", list2);
		    	List<Posts> list3=pss.showpostsbyt_idservice(3);
		    	session.setAttribute("SWZL", list3);
		    	List<Typ> list4=ts.showalltypeservice();
		    	session.setAttribute("Alltype", list4);
		    	List<Posts> list5=pss.showallpostsservice();
		    	session.setAttribute("Allposts", list5);
		    	List<Typ> list6=ts.showalltypeservice();
		    	session.setAttribute("typelist", list6);
		    	response.sendRedirect("aSchoolmain.jsp");
		    }else if("click".equals(act)){
		    	Postsservice pss=new PostsserviceImpl();
		    	Usersservice uss=new UsersserviceImpl();
		    	int p_id=Integer.parseInt(request.getParameter("p_id"));
		    	List<Posts> list=pss.showpostsbyp_idservice(p_id);   //�������ӱ�Ż�ȡ��������
		    	int u_id=list.get(0).getU_id();
		    	if(u_id==0){
		    		Users u=new Users();
		    		u.setU_name("����Ա");
		    		session.setAttribute("postwriter", u);
		    	}else{
		    		Users u=uss.selectnamebyu_idservice(u_id);  //�����û�ID����û�����
		    		session.setAttribute("postwriter", u); 
		    	}
		    	Dissservice ds=new DissserviceImpl();
		    	List<Diss> dlist=ds.showdissbyp_idservice(p_id);   //��������ID��ѯ��������
		    	List<Users> userslist=new ArrayList<Users>();  //���������û�����
		    	for (Diss dl : dlist) {
		    		userslist.add(uss.selectnamebyu_idservice(dl.getU_id())); //�����۵������û����뼯��
				}
		    	session.setAttribute("userslist", userslist);
		    	session.setAttribute("disslist", dlist);   //�����������
		    	session.setAttribute("postdetail",list);    //�����������
		    	response.sendRedirect("aPostsdetails.jsp");     
		    }else if("diss".equals(act)){
		    		Usersservice uss=new UsersserviceImpl();
		    		Dissservice dss=new DissserviceImpl();
		    		Diss d=new Diss();
		    		Postsservice pss=new PostsserviceImpl();
		    		int p_id=Integer.parseInt(request.getParameter("p_id"));  //���۵����ӱ��
		    		Date dat=new Date();
					DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String d_time=format.format(dat);    //���۵�ʱ��
					int u_id=uss.selectusersbyu_nameservice((String) session.getAttribute("users")).getU_id();//�����û���¼����ȡ�û�ID
		    		String d_content=request.getParameter("d_content");   //��������
		    		d.setD_content(d_content);
		    		d.setD_time(d_time);
		    		d.setU_id(u_id);
		    		d.setP_id(p_id);
		    		dss.adddissservice(d);               //����һ������
		    		pss.updatep_ntimeservice(d_time, p_id);   //�������ӵ����¶�̬ʱ��
		    		
			    	List<Diss> dlist=dss.showdissbyp_idservice(p_id);   //��������ID��ѯ��������
			    	List<Users> userslist=new ArrayList<Users>();  //���������û�����
			    	for (Diss dl : dlist) {
			    		userslist.add(uss.selectnamebyu_idservice(dl.getU_id())); //�����۵������û����뼯��
					}
			    	session.setAttribute("userslist", userslist);
			    	session.setAttribute("disslist", dlist);   //�����������
		    		response.sendRedirect("aPostsdetails.jsp"); 
		    	} 
		    
		    else if("clicktype".equals(act)){
		    	int t_id=Integer.parseInt(request.getParameter("t_id"));
		        Postsservice pss=new PostsserviceImpl();
		        List<Posts> list=pss.showpostbyt_idservice(t_id);
		        session.setAttribute("Allposts", list);
		        response.sendRedirect("aSchoolmain.jsp");
		    } 
		    else if("posting".equals(act)){
		    	if(session.getAttribute("users")==null){
		    		response.sendRedirect("index.jsp");   //���δ��¼  ת������¼ҳ��
		    	}else{
		    		Usersservice uss=new UsersserviceImpl();
		    		String p_title=request.getParameter("p_title");
		    		String p_content=request.getParameter("p_content");
		    		String u_name=session.getAttribute("users").toString();  //��ȡ�û���
		    		int u_id=uss.selectusersbyu_nameservice(u_name).getU_id(); //�����û�����ȡ�û����
		    		Date dat=new Date();
					DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String p_time=format.format(dat);    //������ʱ��
					String p_ntime=format.format(dat);
					int p_state=1;
					int t_id=Integer.parseInt(request.getParameter("selec"));
					Postsservice pss=new PostsserviceImpl();
					Posts p=new Posts();
					p.setP_title(p_title);
					p.setP_content(p_content);
					p.setP_time(p_time);
					p.setP_ntime(p_ntime);
					p.setP_state(p_state);
					p.setT_id(t_id);
					p.setU_id(u_id);
					pss.addpostsdao(p);
					session.removeAttribute("MRCB");  //���session
					response.sendRedirect("aSchoolmain.jsp");
		    	}
		    }
		    else if("delete".equals(act)){
		    	int p_id=Integer.parseInt(request.getParameter("p_id"));  //ɾ�������޸�p_stateΪ2
		    	Postsservice pss=new PostsserviceImpl();
		    	pss.updatep_stateservice(2, p_id);      
		    	session.removeAttribute("MRCB");  //���session
				response.sendRedirect("aSchoolmain.jsp");
		    }
		    else if("top".equals(act)){
		    	int p_id=Integer.parseInt(request.getParameter("p_id")); //�ö����� �޸�p_stateΪ3
		    	Postsservice pss=new PostsserviceImpl();
		    	pss.updatep_stateservice(3, p_id);   
		    	String p_title=pss.showpostsbyp_idservice(p_id).get(0).getP_title();//��ȡ���ӱ���
		    	StringBuffer p_newtitle=new StringBuffer("[��]");
		    	p_newtitle.append(p_title);
		    	pss.updatep_titlebyp_idservice(p_newtitle.toString(), p_id);//���ö����Ӽ���[��]��
		    	session.removeAttribute("MRCB");  //���session
				response.sendRedirect("aSchoolmain.jsp");
		    }
		    else if("back".equals(act)){
		    	session.removeAttribute("MRCB");
		    	response.sendRedirect("aSchoolmain.jsp");
		    }
	}

}
