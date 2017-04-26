<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>校园论坛首页</title>
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>
	</head>
	<body style="background-image: url('images/BJ1.jpg');">
	<script language="javascript" type="text/javascript">
           window.onbeforeunload=function(){
               session.remove("MRCB");
           } 
    </script>
	
	
	<div id="page">

	
	<div class="page-inner" style="background-color:rgba(255, 255, 255, 0.5);">
	<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">
			
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo">
					
 	
       <a> 欢迎：${sessionScope.users } 管理员! <em>.</em></a>
       <div><a href="adminservlet?act=out">注&nbsp;销</a></div>
				</div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li><a href="aSchoolmain.jsp">校园中心</a></li>
						<li><a href="aClub.jsp">社团中心</a></li>
						<li><a href="UserManage.jsp">用户管理</a></li>
						<li class="btn-cta"><a href="admmain.jsp"><span>登录</span></a></li>
					</ul>
				</div>
			</div>
			
		</div>
	</nav>
	
	


	

<link href="CSS1/main.css" rel="stylesheet" type="text/css">
<div id="header" style="width: 100%;">

  <div id="nav">
    
    <div id="a_b01"> <img src="images/logo.png" alt="" width="100%" height="110px"> </div>
  
  </div>
</div>
<div id="container" style="background-color:rgba(255, 255, 255, 0.5);height: 900">
<div class="sidebar"style="background-color:rgba(255, 255, 255, 0.3);">
    <h1> <img src="images/title_1.gif" alt="每日晨报"> </h1>
    <div class="side_list">
      <ul>
      														
         <c:if test="${empty sessionScope.MRCB }" >             <!-- 进入控制层 -->
         <c:redirect url="aPostservlet?act=showMRCB"></c:redirect>
         </c:if> 
                                                                <!-- 显示每日晨报 -->
         <c:forEach items="${sessionScope.MRCB}" var="go" >
         <li><h5> <a href="aPostservlet?act=click&p_id=${go.p_id }"><b>${go.p_title }</b></a> </h5></li>
         </c:forEach>
      	   
      </ul>
    </div>
    <h1> <img src="images/title_2.gif" alt="校园趣闻"> </h1>
    <div class="side_list">
      <ul>
      															<!-- 显示校园趣闻 -->
         <c:forEach items="${sessionScope.XYQW}" var="go" >
         <li><h5> <a href="aPostservlet?act=click&p_id=${go.p_id }"><b>${go.p_title }</b></a></h5> </li>
         </c:forEach>
      	
      </ul>
    </div>
    <h1> <img src="images/title_3.gif" alt="失物招领"> </h1>
    <div class="side_list">
      <ul>
      	 														<!-- 显示失物招领 -->
      	 <c:forEach items="${sessionScope.SWZL}" var="go" >
         <li><h5> <a href="aPostservlet?act=click&p_id=${go.p_id }"><b>${go.p_title }</b></a> </h5></li>
         </c:forEach>
      	
      </ul>
    </div>
  </div>


  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="论坛中心"  " style="height: 44px; width: 500px; "> </div>
    <div class="content">
      <ul class="class_date">
      	<li id="class_month">      
      	                                               		<!-- 显示所有类别 -->
      	 <c:forEach items="${sessionScope.Alltype}" var="go" >
         <a href="aPostservlet?act=clicktype&t_id=${go.t_id }"><b>${go.t_type }</b></a>
         </c:forEach>
      		
      </li></ul>
      <ul class="classlist">								<!-- 显示所有帖子 -->
      	     <c:forEach items="${sessionScope.Allposts}" var="go" >
             <li> <a href="aPostservlet?act=click&p_id=${go.p_id }"><b>${go.p_title }</b></a> 
             <span> ${go.p_ntime }</span><br><a href="aPostservlet?act=delete&p_id=${go.p_id }">删除</a>&nbsp;&nbsp;
             <a href="aPostservlet?act=top&p_id=${go.p_id }">置顶</a>
              </li>
             </c:forEach>
      	   
      		<p align="right"> 当前页数:[1/3]&nbsp; <a href="">下一页&nbsp;&nbsp;</a> <a href="">末页</a> </p>
       </ul>
       
       <div style="width: 500px">
       <form action="aPostservlet?act=posting" method="post">
               用户名：
    
    <input style="background-color: #D2F2FE" id="cauthor" name="cauthor" value="${users }"></td>
    
    <br><br> 
              标&nbsp;&nbsp;&nbsp;题：&nbsp;<input style="background-color: #D2F2FE" type="text" name="p_title" cols="70" rows="10" value="请输入帖子标题" 
               onfocus="if (value =='请输入帖子标题'){value =''}" onblur="if (value ==''){value='请输入帖子标题'}" 
              >
          &nbsp;&nbsp;&nbsp;&nbsp;
              帖子类型：<select name="selec" style="background-color: #D2F2FE">
                 <c:forEach items="${sessionScope.typelist}" var="go" >
                 <option value="${go.t_id }">${go.t_type}</option>
         		 </c:forEach>
              </select>
              <br><br> 
            <textarea style="background-color: #D2F2FE" name="p_content" cols="70" rows="10"  onfocus="if (value =='内容'){value =''}" onblur="if (value ==''){value='内容'}" >内容</textarea>
            <input name="submit" value="发  表" type="submit">
       </form>
       </div>
       
    </div>
    <div class="picnews">
  <ul>
    <li> <a href=""><img src="images/Picture1.jpg" width="249" height="180" alt=""> </a><a href="">初春校园樱花</a> </li>
    <li> <a href=""><img src="images/Picture2.jpg" width="249" height="180" alt=""> </a><a href="">丰富的社团活动</a> </li>
    <li> <a href=""><img src="images/Picture3.jpg" width="249" height="180" alt=""> </a><a href="">美丽的人行道</a> </li>
  </ul>
</div>
  </div>
</div>






	<footer id="gtco-footer" role="contentinfo">
		<div class="gtco-container">
			<div class="row row-p	b-md">

				<div class="col-md-4">
					<div class="gtco-widget">
						<h3>About <span class="footer-logo">Splash<span>.<span></span></h3>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempore eos molestias quod sint ipsum possimus temporibus officia iste perspiciatis consectetur in fugiat repudiandae cum. Totam cupiditate nostrum ut neque ab?</p>
					</div>
				</div>

				<div class="col-md-4 col-md-push-1">
					<div class="gtco-widget">
						<h3>Links</h3>
						<ul class="gtco-footer-links">
							<li><a href="#">Knowledge Base</a></li>
							<li><a href="#">Career</a></li>
							<li><a href="#">Press</a></li>
							<li><a href="#">Terms of services</a></li>
							<li><a href="#">Privacy Policy</a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-4">
					<div class="gtco-widget">
						<h3>Get In Touch</h3>
						<ul class="gtco-quick-contact">
							<li><a href="#"><i class="icon-phone"></i> +1 234 567 890</a></li>
							<li><a href="#"><i class="icon-mail2"></i> info@</a></li>
							<li><a href="#"><i class="icon-chat"></i> Live Chat</a></li>
						</ul>
					</div>
				</div>

			</div>

			<div class="row copyright">
				<div class="col-md-12">
					<p class="pull-left">
						<small class="block">Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></small> 
					</p>
					<p class="pull-right">
						<ul class="gtco-social-icons pull-right">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
					</p>
				</div>
			</div>

		</div>
	</footer>
	</div>

	</div>

	
	</body>
</html>

