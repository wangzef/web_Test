<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息</title>
    

  </head>
  		 <c:if test="${empty personmsg }" >             <!-- 进入控制层 -->
         <c:redirect url="UserServlet?act=personmsg"></c:redirect>
         </c:if>
  <body>
    <div style="border: solid;width: 500px;text-align: center; margin-left: 350" >
    <form action="UserServlet?act=changemsg" method="post"enctype="multipart/form-data" method="post">
    <img alt="头像" src="${personmsg.u_photo}" width="60px" height="80px">   <br><br>
    更换头像：<input type="file" name="fileName">								<br><br>
    用户名：<input type="text" value="${personmsg.u_name}" name="name">	<p>${pwrong}</p>						<br><br>
    密码：	<input type="text" value="${personmsg.u_pwd}" name="pwd">							<br><br>
    性别：	<input type="text" value="${personmsg.u_sex}" name="sex">							<br><br>
    入学日期：<input type="text" value="${personmsg.u_year}" name="year">							<br><br>
    专业：	<input type="text" value="${personmsg.u_major}" name="major">							<br><br>
    注册时间：	<input type="text" value="${personmsg.u_regtime}" readonly="readonly">		<br><br>				<br>
    <input type="submit" value="确认修改"> &nbsp;&nbsp;&nbsp;<a href="Schoolmain.jsp"><input type="button" value="返回"></a>
    </form>
    </div>
  </body>
</html>
