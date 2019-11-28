<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <title>慧云网安测评系统</title>
    <link rel="stylesheet" type="text/css" href="${base }/css/iconfont/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${base }/css/login.css">
    <script type="text/javascript">
		if (window != top) 
			top.location.href = location.href; 
    </script>
</head>
<body>
	<div class="loginHead">
		<div class="headCenter">
			<h2 class="logo pull-left">测评系统 <small>BETA</small></h2>
		</div>
	</div>
	<div class="loginMain">
		<form class="loginFrom" id="loginForm">	
			<div class="inputDiv">
				<span id="errorMsg" style="color:red;text-align:center;"></span>
			</div>
			<div class="inputDiv">
				<i class="iconfont">&#xe604;</i>
				<input id="username"  name="username"  type="text" placeholder="请输入用户名" onfocus="removeErrorMsg();" >
			</div>
			<div class="inputDiv">
				<i class="iconfont">&#xe602;</i>
				<input id="password" name="password" placeholder="账号密码" onfocus="this.type='password',removeErrorMsg();" >
			</div>
			<div class="loginBtn">
				<input type="button" id="submit" onclick="doctorLogin();" value="登录">
			</div>
			
			<div class="mTop20">
				<div class="pull-left readme"><lable><input type="checkbox" name="readme">在电脑上保存登录</lable></div>
				<!-- <div class="pull-right forget"><a href="javascript:void(0)" onclick="toForgetPasswd();" title="忘记密码">忘记密码</a></div> -->
			</div>
		</form>
	</div>
	
	<div class="footer">
		<p>Copyright © 2015 - 2020测评系统   慧科教育科技有限公司 Rights Reserved.</p>
	</div>
</body>
<script type="text/javascript">
	var base='${base }';
</script>
<script type="text/javascript" src="${base }/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${base }/js/login.js"></script>
</html>
