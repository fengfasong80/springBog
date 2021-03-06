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
   <div id="menuGridToolBar">
		<table>
			<tr>
					<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" id="addRootMenuBtn">添加一级菜单</a></td>
					<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" id="addChildMenuBtn">添加子菜单</a></td>
					<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit" id="updateMenuBtn">修改</a></td>
					<td><a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" id="deleteMenuBtn">删除</a></td>
			</tr>
		</table>
	</div>
	<table title="菜单管理" class="easyui-treegrid" id="menuTreeGrid" url="${base }/right/menu/renderAsyncTree" rownumbers="true" idField="id" treeField="text" nowrap=true
    striped=true fitColumns=true fit=true toolbar='#menuGridToolBar'>
    <thead>
        <tr>
            <th field="text" width="250">菜单名称</th>
            <th field="url" width="100" >地址</th>
            <th field="position" width="100">菜单位置</th>
            <th field="iconCls" width="100" >样式</th>
        </tr>
    </thead>
	</table>
	
	<div id="menuWin" title="菜单管理"  data-options="footer:'#ft'">
	    <form id="menuForm" style="padding:10px 20px 10px 40px;" method="post" enctype="multipart/form-data">
	    <input type="text" name="id" class="hide">
	    <input type="text" name="parentId" class="hide" id="parentMenuIdIpt">
	    <table>
	    	<tr>
	    		<td>菜单名称: </td>
	    		<td><input type="text" name="text" class="easyui-textbox" data-options="required:true"></td>
	    	</tr>
	    	<tr>
	    		<td>地址: </td>
	    		<td><input type="text" name="url" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    		<td>样式: </td>
	    		<td><input type="text" name="iconCls" class="easyui-textbox"></td>
	    	</tr>
	    	<tr>
	    		<td>位置: </td>
	    		<td><input type="text" name="position" class="easyui-numberbox"></td>
	    	</tr>
	    </table>
	    </form>
	     <div style="padding:5px;text-align:right;" id="ft">
	            <a href="#" class="easyui-linkbutton" plain="true" icon="icon-ok" id="saveMenuSbmt">保存</a>&nbsp
	            <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" id="closeMenuWinBtn">取消</a>
	     </div>
	</div>
	
</body>
<script type="text/javascript">
		var base='${base }';
</script>
<script type="text/javascript" src="${base }/js/right/menu.js"></script>
</html>