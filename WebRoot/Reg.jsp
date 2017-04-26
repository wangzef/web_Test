<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--[if IE 8 ]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9 ]> <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>用户注册</title>


<!--[if lt IE 9]>
<script src="reg/js/html5shiv.js"></script>
<![endif]-->

<link href="reg/css/normalize.css" rel="stylesheet"/>
<link href="reg/css/jquery-ui.css" rel="stylesheet"/>
<link href="reg/css/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>

<style type="text/css">
body{font:normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;color: #222;background:url
(reg/pattern.png);overflow-y:scroll;padding:60px 0 0 0;}
#my-form{width:755px;margin:0 auto;border:1px solid #ccc;padding:3em;border-radius:3px;box-shadow:0 0 2px rgba

(0,0,0,.2);}
#comments{width:350px;height:100px;}
</style>

</head>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
		function checkName(obj) {
		var username = $(obj).val();
		$.ajax({
			url : "Regservlet?act=check",
			type : "post",
			data : {
				"username" : username
			},
			dataType : "json",
			success : function(data) {     
				$("#msg").html(data.flag); 
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(XMLHttpRequest.readyState);
				alert(XMLHttpRequest.status);
				alert(textStatus);
			}
		});
		
	}
	

	</script>
<body>


<div class="row">

  <div class="eightcol last">

    <!-- Begin Form -->
<a href="index.jsp"><h3>返回主页</h3></a>
    <form id="my-form" action="Regservlet?act=reg" enctype="multipart/form-data" method="post" >
        <section name="步骤">
          <div><label>用户名:</label><input id="username" name="username" type="text" onblur="checkName(this)"/></div>
          <div><label>密码:</label><input id="pass" name="password" type="password"/></div>
          <div><label>性别:</label><input id="email" name="sex"  type="email"/></div>
          <div><label>入学年份:</label><input name="date" class="datepicker" data-ideal="date" type="text" 
placeholder="月/日/年"/></div>
          <div><label>上传头像:</label><input id="file" name="fileName" multiple type="file"/></div>
          <div><label>专业:</label><input name="website"  type="text"/></div><br>
          <p style="color: red;" id="msg"></p>
        </section>
      <div><hr/></div>
      <div>
        <button type="submit">提交</button>
        <button id="reset" type="button">重置</button>
      </div>

    </form>

    <!-- End Form -->

  </div>

</div>


<script type="text/javascript" src="reg/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="reg/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="reg/js/jquery.idealforms.js"></script>

<script type="text/javascript">
var options = {
	onFail: function(){
	},

	inputs: {
		'password': {
			filters: 'required pass',
		},
		'username': {
			filters: 'required username',
			data: {
			//ajax: { url:'validate.php' }
			}
		},
		'file': {
			filters: 'extension',
			data: { extension: ['jpg'] }
		},
		'comments': {
			filters: 'min max',
			data: { min: 50, max: 200 }
		},
		'states': {
			filters: 'exclude',
			data: { exclude: ['default'] },
			errors : {
				exclude: '选择国籍.'
			}
		},
		'langs[]': {
			filters: 'min max',
			data: { min: 2, max: 3 },
			errors: {
				min: 'Check at least <strong>2</strong> options.',
				max: 'No more than <strong>3</strong> options allowed.'
			}
		}
	}
	
};

var $myform = $('#my-form').idealforms(options).data('idealforms');

$('#reset').click(function(){
	$myform.reset().fresh().focusFirst()
});

$myform.focusFirst();
</script>
<div style="text-align:center;">
<p>来源：<a href="#" title="源码之家" target="_blank">校园论坛</a></p>
</div>
</body>
</html>