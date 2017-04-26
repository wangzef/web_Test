<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
	<title>社团首页</title>
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
	<style css/text>
	#bg{ 
	width: 100%;
    height: 100%;
    background:url('images/BJ1.jpg')no-repeat;
    background-size:100%;
	}
	</style>
	</head>
		<body id="bg">
	<!-- Google fonts -->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700' rel='stylesheet' type='text/css'>

<!-- font awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">

<!-- bootstrap -->
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />

<!-- animate.css -->
<link rel="stylesheet" href="assets/animate/animate.css" />
<link rel="stylesheet" href="assets/animate/set.css" />

<!-- gallery -->
<link rel="stylesheet" href="assets/gallery/blueimp-gallery.min.css">

<!-- favicon -->
<link rel="shortcut icon" href="images2/favicon.ico" type="image/x-icon">
<link rel="icon" href="images2/favicon.ico" type="image/x-icon">


<link rel="stylesheet" href="assets/style.css">


<nav class="gtco-nav" role="navigation">
		<div class="gtco-container" >
			
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo">
					
 	<c:choose>
    <c:when test="${empty sessionScope.welcome}" ><a href="index.jsp">登录<em>.</em></a></c:when>
    <c:otherwise> 
       <a> 欢迎：${sessionScope.welcome } ! <em>.</em></a>
       <div><a href="adminservlet?act=out">注&nbsp;销</a></div>
    </c:otherwise>
    </c:choose>

				</div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li><a href="Schoolmain.jsp">校园中心</a></li>
						<li><a href="Club.jsp">社团中心</a></li>
						<li><a href="person.jsp">个人资料</a></li>
						<li class="btn-cta"><a href="index.jsp"><span>登录</span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>


<!-- works -->
<div id="works"  class=" clearfix grid"> 
    <figure class="effect-oscar  wowload fadeIn">
        <img src="images2/portfolio/1.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>篮球社</h2>
            <p>篮球，给想飞翔的你，带去翅膀！ 无兄弟,不篮球。报名Q群：421125362<br>
            <a href="images2/portfolio/1.jpg" title="1" data-gallery >查看详情</a></p>            
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/2.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>吉他社</h2>
            <p>弦系我心，弹出你的风采。报名Q群：421125362<br>
            <a href="images2/portfolio/2.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/3.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>摄影社</h2>
            <p>捕捉美丽瞬间，留住最美一刻！报名Q群：421125362<br>
            <a href="images2/portfolio/3.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/4.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>轮滑社</h2>
            <p>上帝忘记给我们装翅膀` 所以我们用轮滑来飞翔。报名Q群：421125362<br>
            <a href="images2/portfolio/4.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/5.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>滑板社</h2>
            <p>仰望天空，脚踏实地，酷炫你我，滑板给力。报名Q群：421125362<br>
            <a href="images2/portfolio/5.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
     
     <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/6.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>舞蹈社</h2>
            <p>心随舞动,舞动快乐,舞动奇迹!报名Q群：421125362<br>
            <a href="images2/portfolio/6.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
    <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/7.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>动漫社</h2>
            <p>爱二次元，爱动漫，动漫生活，从此开始。报名Q群：421125362<br>
            <a href="images2/portfolio/7.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
    <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/8.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>击剑社</h2>
            <p>挥发汗水速度和击打的快感。报名Q群：421125362<br>
            <a href="images2/portfolio/8.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
    <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/9.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>骑行协会</h2>
            <p>燃烧生命激情，释我青春活，单车身活，踩动地球。报名Q群：421125362<br>
            <a href="images2/portfolio/9.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
    <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/10.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>相声社</h2>
            <p>如果你喜欢给大家带来欢笑，这里就是你的家。报名Q群：421125362<br>
            <a href="images2/portfolio/10.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
    <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/11.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>足球社</h2>
            <p>玩转草根，足下加油。报名Q群：421125362<br>
            <a href="images2/portfolio/11.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
    <figure class="effect-oscar  wowload fadeInUp">
        <img src="images2/portfolio/12.jpg" alt="img01" style="height: 280;width: 423"/>
        <figcaption>
            <h2>古风社</h2>
            <p> 一卷江山一卷画，一折红尘去风华，莫问千年一剑为谁杀，那一壶半凉的茶。报名Q群：421125362<br>
            <a href="images2/portfolio/12.jpg" title="1" data-gallery>查看详情</a></p>            
        </figcaption>
    </figure>
    

     
</div>

<!-- Footer Starts -->
<div class="footer text-center spacer">
<p class="wowload flipInX"><a href="#"><i class="fa fa-facebook fa-2x"></i></a> <a href="#"><i class="fa fa-instagram fa-2x"></i></a> <a href="#"><i class="fa fa-twitter fa-2x"></i></a> <a href="#"><i class="fa fa-flickr fa-2x"></i></a> </p>
Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://www.moke8.com/html/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
</div>
<!-- # Footer Ends -->
<a href="#works" class="gototop "><i class="fa fa-angle-up  fa-3x"></i></a>

<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
<div id="blueimp-gallery" class="blueimp-gallery blueimp-gallery-controls">
    <!-- The container for the modal slides -->
    <div class="slides"></div>
    <!-- Controls for the borderless lightbox -->
    <h3 class="title">Title</h3>
    <a class="prev">‹</a>
    <a class="next">›</a>
    <a class="close">×</a>
    <!-- The modal dialog, which will be used to wrap the lightbox content -->    
</div>



<!-- jquery -->
<script src="assets/jquery.js"></script>

<!-- wow script -->
<script src="assets/wow/wow.min.js"></script>


<!-- boostrap -->
<script src="assets/bootstrap/js/bootstrap.js" type="text/javascript" ></script>

<!-- jquery mobile -->
<script src="assets/mobile/touchSwipe.min.js"></script>
<script src="assets/respond/respond.js"></script>

<!-- gallery -->
<script src="assets/gallery/jquery.blueimp-gallery.min.js"></script>

<!-- custom script -->
<script src="assets/script.js"></script>
	
	
	
	
	
	</body>
	
	</html>