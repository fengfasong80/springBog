<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<title>台管理系统</title>
	<link rel="stylesheet" type="text/css" href="${base }/css/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${base }/css/moreIcons/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="${base }/css/icon.css">
	<link rel="stylesheet" type="text/css" href="${base }/css/iconfont/iconfont.css">
	<link rel="stylesheet" type="text/css" href="${base }/css/rf.css">
</head>
<body class="easyui-layout">
	<!--头部-->
	<div data-options="region:'north',border:false,split:false" class="mod-head">
		<a href="/index.jsp" class="logo" title="大数据后台管理系统">大数据后台管理系统<small>BTEA</small></a>
		<div class="syswel">
			<ul class="topNav">
				<li class="sysweltxt">欢迎,&nbsp
						${admin.realname }
				</li>
				<li class="notice">
					<a href="/doc/help.pdf" target="_blank" title="使用帮助"><i class="iconfont">&#xe606;</i>使用帮助</a>
				</li>
				<!-- <li class="notice">
					<a href="javascript:void(0);" title="参与人数"><i class="iconfont">&#xe600;</i>参与人数</a>
					<span class="no_num" id="userCount">0</span>
				</li> -->
				<li class="orderAlarm"><a href="javascript:void(0);" onclick="openUpdatePwdWin();" title="修改密码"><i class="iconfont">&#xe606;</i>修改密码</a></li>
				<li class="outSys"><a href="javascript:void(0);" title="安全退出" onclick="logout()"><i class="iconfont">&#xe601;</i>安全退出</a></li>
			</ul>
		</div>
	</div>
	<!--/头部-->
	<!--面板导航-->
    <div data-options="region:'west',title:'导航菜单',split:false"  class="mod-sildeNav">
    	<div id="sildeAccordion" class="easyui-accordion mod-navItem" data-options="border:false,fit:true"></div>
    </div>
    <!--/面板导航-->
    <!--主体内容区域-->
    <div data-options="region:'center'" class="mod-body">
		<div id="manageTab" class="easyui-tabs" data-options="tools:'#tab-tools',border:false,width:'auto',fit:true">
		</div>
    </div>
    
    <div id="updatePasswordWin" title="修改密码" style="width:300px; height:180px; padding: 10px 10px" data-options="closed:true,resizable:false,modal:true,minimizable:false,collapsible:false,maximizable:false, footer:'#dlg-buttons'" class="easyui-window" >
		<form id="updatePasswordForm">
			<table>
				<tr>
					<td>原 密 码:</td>
					<td><input class="easyui-textbox" name="oldPassword" type="password" data-options="required:true"></td>
				</tr>
				<tr>
					<td>新 密 码:</td>
					<td><input class="easyui-textbox" id="pwd" type="password" name="password"  data-options="required:true"></td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td><input id="rpwd" validType="equalTo['#pwd']" invalidMessage="两次输入密码不匹配" data-options="required:true" type="password" name="renewPassword" class="easyui-textbox easyui-validatebox" ></td>
				</tr>
			</table>
		</form>
		
		<div id="dlg-buttons" style="padding:5px;text-align:right;">
			<a href="javascript:void(0)" class="easyui-linkbutton c6" plain="true" iconCls="icon-ok"  style="width: 90px" id="updatePasswordSubBtn">保存</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="icon-cancel"
			   onclick="javascript:$('#updatePasswordWin').window('close')" style="width: 90px">关闭</a>
		</div>
    </div>
    
    <!--/主体内容区域-->
     <!-- 鼠标右键关闭菜单选项 -->
	<div id="rcmenu" class="easyui-menu">
	    <div id="closecur">关闭当前</div>
	    <div id="closeall">关闭全部</div>
	    <div id="closeother">关闭其他</div>
	    <div class="menu-sep"></div>
	    <div id="closeright">关闭右侧</div>
	    <div id="closeleft">关闭左侧</div>
	</div>	
	<!--页脚-->
	<div data-options="region:'south',border:false,split:false" class="mod-footer">
		Copyright © 2017 - 2020 贵州科技有限公司 Rights Reserved.
	</div>
	<!--/end 页脚-->
	<script type="text/javascript">
		var base='${base }';
	</script>
	<script type="text/javascript" src="${base }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${base }/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${base }/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${base }/js/global.js"></script>
	<script type="text/javascript" src="${base }/js/plugin.js"></script>
	<script type="text/javascript" src="${base }/js/close-tab.js"></script>
	<script type="text/javascript" src="${base }/js/index.js"></script>
</body>
</html>



