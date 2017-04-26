<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0060)http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78 -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=GBK">
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<title>校园新闻网</title>
	<style type="text/css">
	.box1{position:relative;height: 80px;margin:5px;}
	.box2{position:absolute;left: 115px;top:10px;bottom:10px;}
	.box3{position:absolute;left: 480px;top:10px;bottom:10px;}
	.box4{position:absolute;left: 20px; }
	.d1{position:absolute;left: 20px;}
	.d2{position:absolute;left: 115px;top:10px;bottom:10px;margin:10px;}
	.d3{position:relative;height: 120px;margin:5px;}
	</style>
	
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
		function showpmsg(obj) {
		var name = $(obj).attr("name");
		$.ajax({
			url : "UserServlet?act=showpmsg",
			type : "post",
			data : {
				"name":name
			},
			dataType : "json",
			success : function(data) {     
			    document.getElementById(name).style.display="block"; 
				$("#"+name).html(data.flag); 
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.readyState);
				alert(XMLHttpRequest.status);
				alert(textStatus);
			}
		});
		
	}
	function hide(obj) {
	    var name = $(obj).attr("name");
		document.getElementById(name).style.display="none";
	}
	</script>
	
	<style css/text>
	#bg{ 
	width: 100%;
    height: 100%;
    background:url('images/BJ1.jpg')no-repeat;
    background-size:100%;
	}
	</style>
	<link href="CSS1/main.css" rel="stylesheet" type="text/css">
	
</head>
<body id="bg">
<a href="aPostservlet?act=back"><h2>《《返回主页</h2></a>
<div id="header">
	
  <div id="nav">
    
    <div id="a_b01"> <img src="images/logo.png" alt="" width="947" height="110px"> </div>
  
  </div>
</div>


<link href="CSS1/read.css" rel="stylesheet" type="text/css">


<div id="container"style="background-color:rgba(255, 255, 255, 0.5);">
  




<div class="sidebar" style="background-color:rgba(255, 255, 255, 0.5);">
    <h1> <img src="images/title_1.gif" alt="每日晨报" width="157" > </h1>
    <div class="side_list">
      <ul>
      													
         <c:if test="${empty sessionScope.MRCB }" >             <!-- 进入控制层 -->
         <c:redirect url="aPostservlet?act=showMRCB"></c:redirect>
         </c:if> 
                                                                <!-- 显示每日晨报 -->
         <c:forEach items="${sessionScope.MRCB}" var="go" >
         <li><h3><a href="aPostservlet?act=click&p_id=${go.p_id }"><p>${go.p_title }</p></a></h3> <br/></li>
         </c:forEach>
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="国际新闻"> </h1>
    <div class="side_list">
      <ul>
      	
      	  														<!-- 显示校园趣闻 -->
         <c:forEach items="${sessionScope.XYQW}" var="go" >
         <li><h3> <a href="aPostservlet?act=click&p_id=${go.p_id }"><b>${go.p_title }</b></a></h3><br/> </li>
         </c:forEach>
     		
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="娱乐新闻"> </h1>
    <div class="side_list">
      <ul>
      	
      		 														<!-- 显示失物招领 -->
      	 <c:forEach items="${sessionScope.SWZL}" var="go" >
         <li><h3> <a href="aPostservlet?act=click&p_id=${go.p_id }"><b>${go.p_title }</b></a></h3><br/> </li>
         </c:forEach>
      	
      </ul>
    </div>
  </div>

  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" style="width: 620px;height: 44px"> </div>
    <div class="content">
      <ul class="classlist">
          <h1 style="position: absolute;left: 590px">${postdetail.get(0).p_title}</h1><br/>
           <br/>
            <hr style="width: 640px"/>
            <h3 style="position: absolute;left: 590px">${postdetail.get(0).p_time }</h3>
            <strong>&nbsp; </strong>
          <div class="d3" style=" width: 620px">
           <div class="d1" style="border:solid gray;height: 80px; width: 50px; margin-top: 20px;"><img alt="头像" src="${postwriter.u_photo }" style="height: 60px" width="50px" align="top" onmouseover="showpmsg(this)" onmouseout="hide(this)"/>
           <p style="color: blue;">${postwriter.u_name }</p>
           </div><br/>
           <div id="${postwriter.u_name }" style="display: none;border:solid #CFE6F2; background-color:rgba(255, 255, 255, 0.8);height: 130px;width: 140px;position: absolute;z-index: 1;left: 90px;"></div>
            <div class="d2" style=" width: 400px;"><h3>${postdetail.get(0).p_content}</h3></div>
         </div>
          </tr>
          
          <tr>
           <strong>&nbsp; </strong>
           <hr style="width: 640px"/>
            </td>
          </tr>
       
      </ul>
      
        
     	  
       
   <br/>     	  
 <h3>已  有  回 帖:</h3>
 <br/>
  <div style=" width: 620px" >
       	   <c:forEach items="${sessionScope.disslist}" var="dl" >
       	   <br/>
       	   <hr />
       	   <br/>
       	                <div class="box1" style="border:5px ">
           				<div class="box2" style="width: 350px">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h4>${dl.d_content}</h4></div>
           				<div class="box3" style="width: 100px" >${dl.d_time }</div>
       	  
          		 <c:forEach items="${sessionScope.userslist}" var="ul" >
       	   			<c:if test="${ul.u_id eq dl.u_id }">
                         <div class="box4" style="border:solid gray; height: 80px; float:left;">
                         <img alt="头像" src="${ul.u_photo }" style="height: 60px" width="50px" align="top" onmouseover="showpmsg(this)" onmouseout="hide(this)"/><br/>${ul.u_name }</div>
       	   		   <div id="${ul.u_name }" style="display: none;border:solid #CFE6F2; background-color:rgba(255, 255, 255, 0.8);height: 100px;width: 140px;position: absolute;z-index: 1;left: 90px;"></div>
       	   		    </c:if>
           		 </c:forEach>
           		 
           		 
            </div>
           </c:forEach>
       <br/>
     <hr />
      <ul class="classlist">
        <form action="aPostservlet?act=diss&p_id=${postdetail.get(0).p_id }" method="post" onsubmit="return checkComment()">
          <table width="80%" align="center">
            <tbody><tr>
            </tr>
            <tr>
              <td> 用户名： </td>
    <c:choose>
    <c:when test="${empty sessionScope.users}" ><td><input style="background-color: #D2F2FE" id="cauthor" name="cauthor" value="请登录后发表评论！"></c:when>
    <c:otherwise> 
    <td><input style="background-color: #D2F2FE" id="cauthor" name="cauthor" value="${users }">
    </c:otherwise>
    </c:choose>
                IP：
                <input style="background-color: #D2F2FE" name="cip" value="127.0.0.1" readonly="readonly">
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea style="background-color: #D2F2FE" name="d_content" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <tr><td><input name="submit" value="发  表" type="submit">
              </td>
          </tr></tbody></table>
        </form>
      </ul>
    </div>
  </div>
</div>

<div id="friend">
  <h1 class="friend_t"> <img src="images/friend_ico.gif" alt="合作伙伴"> </h1>
  <div class="friend_list">
    <ul>
      <li> <a href="http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78#">中国政府网</a> </li>
      <li> <a href="http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78#">中国政府网</a> </li>
      <li> <a href="http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78#">中国政府网</a> </li>
      <li> <a href="http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78#">中国政府网</a> </li>
      <li> <a href="http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78#">中国政府网</a> </li>
      <li> <a href="http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78#">中国政府网</a> </li>
      <li> <a href="http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78#">中国政府网</a> </li>
    </ul>
  </div>
</div>
<div id="footer">
  <p class=""> 24小时客户服务热线：010-68988888 &nbsp;&nbsp;&nbsp;&nbsp; <a href="http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78#">常见问题解答</a> &nbsp;&nbsp;&nbsp;&nbsp; 新闻热线：010-627488888 <br>
    文明办网文明上网举报电话：010-627488888 &nbsp;&nbsp;&nbsp;&nbsp; 举报邮箱： <a href="http://localhost:8080/NewsManagerSystem/news_read.jsp?nid=78#">jubao@jb-aptech.com.cn</a> </p>
  <p class="copyright"> Copyright &#169; 1999-2009 News China gov, All Right Reserver <br>
    新闻中国 版权所有 </p>
</div>


</body></html>