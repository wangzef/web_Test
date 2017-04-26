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
    <title></title>
  </head>
  <body>
         <c:if test="${empty userinfo }" >             <!-- 进入控制层 -->
         <c:redirect url="UserServlet?act=showusers"></c:redirect>
         </c:if> 
         
     <table border="1px">
     <tr>
     <th>编号</th>
     <th>用户名</th>
     <th>密码</th>
     <th>性别</th>
     <th>头像</th>
     <th>入学时间</th>
     <th>专业</th>
     <th>账号状态</th>
     <th>注册时间</th>
     <th>用户权限</th>
     <th>操作</th>
     </tr>
     <c:forEach items="${sessionScope.userinfo}" var="go" >
     <tr >
     <td>${go.u_id }</td>
     <td>${go.u_name}</td>
     <td>${go.u_pwd}</td>
     <td>${go.u_sex}</td>
     <td>${go.u_photo}</td>
     <td>${go.u_year}</td>
     <td>${go.u_major}</td>
     <td>${go.u_state}</td>
     <td>${go.u_regtime}</td>
     <td>${go.u_limits}</td>
     <td><a href="UserServlet?act=close&u_id=${go.u_id }">禁封</a>&nbsp;<a href="UserServlet?act=open&u_id=${go.u_id }">解封</a></td>
     
     </tr>
     </c:forEach>
     </table><br>      


  </body>
</html>
