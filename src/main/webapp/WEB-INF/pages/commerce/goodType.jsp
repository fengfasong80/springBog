<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${base }/css/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${base }/css/moreIcons/IconExtension.css">
	<link rel="stylesheet" type="text/css" href="${base }/css/icon.css">
	<link rel="stylesheet" type="text/css" href="${base }/css/iconfont/iconfont.css">
	<link rel="stylesheet" type="text/css" href="${base }/css/rf.css">
</head>
<body>
	<table id="goodTypeGrid"></table>
	
	<div id="goodTypeGridToolBar">
		<table>
			<tr>
				<td>
					<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="add()">添加</a>
				</td>
				<td>
					<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit" onclick="update()">修改</a>
				</td>
				<td>
					<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="del()">删除</a>
				</td>
			</tr>
		</table>
	</div>
	
	<!-- 商品添加窗口 -->
	<div id="addGoodTypeWin" title="增加商品信息" 
		class="easyui-window" style="padding: 5px; width: 300px; height: 150px; text-align: center;"
		data-options="footer:'#ft1'">
		<form id="addGoodTypeForm" style="padding: 10px 20px 10px 40px;">
			<table>
				<tr>
					<td>商品类型:</td>
					<td><input type="text" name="name" class="easyui-textbox"
						data-options="required:true" /></td>
				</tr>
			</table>
		</form>
		<div id="ft1" style="padding: 5px; text-align: right;">
			<a href="#" class="easyui-linkbutton" plain="true" icon="icon-ok"
				onclick="addSave()">保存</a>&nbsp <a href="#"
				class="easyui-linkbutton" plain="true" icon="icon-cancel"
				onclick="addClose()">取消</a>
		</div>
	</div>
	
	<!-- 商品更新窗口 -->
	<div id="updateGoodTypeWin" title="修改商品信息" class="easyui-window"
		style="padding: 5px; width: 300px; height: 150px; text-align: center;"
		data-options="footer:'#ft2'">
		<form id="updateGoodTypeForm" style="padding: 10px 20px 10px 40px;">
			<input type="text" name="id" style="display: none" />
			<table>
					<td><input type="text" name="name" class="easyui-textbox"
						data-options="required:true" /></td>
			</table>
		</form>
		<div id="ft2" style="padding: 5px; text-align: right;">
			<a href="#" class="easyui-linkbutton" plain="true" icon="icon-ok"
				onclick="updateSave()">保存</a>&nbsp <a href="#"
				class="easyui-linkbutton" plain="true" icon="icon-cancel"
				onclick="updateClose()">取消</a>
		</div>
	</div>
</body>
	<script type="text/javascript">
		var base='${base }';
	</script>
	<script type="text/javascript" src="${base }/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${base }/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${base }/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${base }/js/plugin.js"></script>
	<script type="text/javascript" src="${base }/js/commerce/goodType.js"></script>
</html>