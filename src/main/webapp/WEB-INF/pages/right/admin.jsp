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
    <table id="adminGrid"></table>
	<div id="addAdminWin" title="增加用户信息" class="easyui-window" style="padding:5px;width:300px;height:400px;text-align: center;" data-options="footer:'#ft1'">
	    <form id="addAdminForm" style="padding:10px 20px 10px 40px; " >
	    	<input type="text" name="id" class="hide">
	    	<table>
	    		<tr>
	    			<td>用户名:</td><td><input type="text" name="username" class="easyui-textbox" data-options="required:true"></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td><td><input type="password" name="password" class="easyui-textbox" data-options="required:true"></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td><td><input type="text" name="realname" class="easyui-textbox" data-options="required:true"></td>
	    		</tr>
	    	</table>
	    </form>
	    <div id="ft1" style="padding: 5px; text-align: right;">
	    		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-ok" onclick="addSave()">保存</a>&nbsp
	    		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="addClose()">取消</a>
	    </div>
	</div>
	
	<div id="updateAdminWin" title="修改用户管理" class="easyui-window" style="padding:5px;width:300px;height:400px;text-align: center;" data-options="footer:'#ft2'">
	    <form id="updateAdminForm" style="padding:10px 20px 10px 40px; " >
	    	<input type="text" name="id" class="hide">
	    	<table>
	    		<tr>
	    			<td><font color=red>用户名:</font></td><td><input type="text" name="username" class="easyui-textbox"  readonly="readonly"></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td><td><input type="text" name="realname" class="easyui-textbox" ></td>
	    		</tr>
	    	</table>
	    </form>
	    <div id="ft2" style="padding: 5px; text-align: right;">
	    		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-ok" onclick="updateSave()">保存</a>&nbsp
	    		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="updateClose()">取消</a>
	    </div>
	</div>
	
	
	<div id="adminGridToolBar">
		<table>
			<tr>
				<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="add()">添加</a></td>
				<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit" onclick="update()">修改</a></td>
				<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="del()">删除</a></td>
			</tr>
		</table>
	</div>
	<!--复选框-->
	<div id="roleWin" class="easyui-window" title="用户角色管理"  style="padding:5px;width:300px;height:400px;text-align: center;"  data-options="footer:'#ft3'">
	<table id="role" class="easyui-datagrid" style="width:300px;height:400px"
			data-options="method:'post'">
	</table>
	</div>	
	<!--操作按钮-->
	<div style="padding:5px;text-align:center;" id="ft3">
		     <a id="saveMenuSbmt" href="#" class="easyui-linkbutton" plain="true" icon="icon-ok" >保存</a>
	         <a id="closeMenuWin" href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" >取消</a>
	</div>
	    </form>
	</div>	
</body>
<script type="text/javascript">
		var base='${base }';
</script>
<script type="text/javascript" src="${base }/js/right/admin.js"></script>
</html>