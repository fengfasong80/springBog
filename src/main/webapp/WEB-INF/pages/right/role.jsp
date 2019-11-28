<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员信息管理</title>
	<link rel="stylesheet" type="text/css" href="${base}/css/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${base}/css/moreIcons/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="${base}/css/icon.css">
	<link rel="stylesheet" type="text/css" href="${base}/css/animate.min.css">
	<link rel="stylesheet" type="text/css" href="${base}/css/iconfont/iconfont.css">
	<link rel="stylesheet" type="text/css" href="${base}/css/rf.css">
	<script type="text/javascript" src="${base }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${base }/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${base }/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${base }/js/global.js"></script>
	<script type="text/javascript" src="${base }/js/plugin.js"></script>
</head>
<body>
    <table id="roleGrid"></table>
	<div id="roleWin" title="角色管理" data-options="footer:'#ft1'">
	    <form id="roleForm" style="padding:10px 20px 10px 40px;">
	    	<input type="text" name="id" class="hide">
	    	<table>
	    		<tr>
	    			<td>角色名:</td><td><input type="text" name="name" class="easyui-textbox" data-options="required:true"></td>
	    		</tr>
	    		<tr>
	    			<td>角色代码:</td><td><input type="text" name="code" class="easyui-textbox"></td>
	    		</tr>
	    	</table>
	    </form>
	    <div id="ft1" style="padding: 5px; text-align: right;">
	    		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-ok" id="saveRoleSbmt">保存</a>&nbsp
	    		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" id="closeRoleWin">取消</a>
	    </div>
	</div>
	
	<div id="roleGridToolBar">
		<table>
			<tr>
				<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" id="addRoleBtn">添加</a></td>
				<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit" id="updateRoleBtn">修改</a></td>
				<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" id="deleteRoleBtn">删除</a></td>
			</tr>
		</table>
	</div>
	
	<div id="menuTreeWin" class="easyui-window" title="菜单权限管理"  data-options="footer:'#ft2'">
	    <form id="menuTreeForm" style="">
	    	<ul id="menuTree"></ul>
	        <div style="padding:5px;text-align:center;" id="ft2">
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-ok" id="saveMenuTreeSbmt">保存</a>
	            <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" id="closeMenuTreeWin">取消</a>
	        </div>
	    </form>
	</div>	
</body>
<script type="text/javascript">
		var base='${base }';
</script>
<script type="text/javascript" src="${base }/js/right/role.js"></script>
</html>