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
	<table id="goodGrid"></table>
	
	<div id="goodGridToolBar">
		<form id="queryGoodForm">
		<table>
			<tr>
				<td>
					商品名称:<input type="text" name="name" class="easyui-textbox"/>
				</td>
				<td>
					<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" onclick="queryGood()">查询</a>
				</td>
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
		</form>
	</div>
	
	<!-- 商品添加窗口 -->
	<div id="addGoodWin" title="增加商品信息" 
		class="easyui-window" style="padding: 5px; width: 300px; height: 400px; text-align: center;"
		data-options="footer:'#ft1'">
		<form id="addGoodForm" style="padding: 10px 20px 10px 40px;">
			<table>
				<tr>
					<td>商品名称:</td>
					<td><input type="text" name="name" class="easyui-textbox"
						data-options="required:true" /></td>
				</tr>
				<tr>
					<td>商品价格:</td>
					<td><input type="text" name="price"
						data-options="min:0,precision:2" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<td>生产日期:</td>
					<td><input type="text" name="productDate"
						class="easyui-datebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>保质期:</td>
					<td><input type="text" name="expiration"
						class="easyui-numberbox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>厂商:</td>
					<td><input type="text" name="production"
						class="easyui-textbox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>商品类别:</td>
					<td>
						<input id="addGoodTypeCombox" name="goodTypeId">
    					</td>
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
	<div id="updateGoodWin" title="修改商品信息" class="easyui-window"
		style="padding: 5px; width: 300px; height: 400px; text-align: center;"
		data-options="footer:'#ft2'">
		<form id="updateGoodForm" style="padding: 10px 20px 10px 40px;">
			<input type="text" name="id" style="display: none" />
			<table>
				<tr>
					<td>商品名称:</td>
					<td><input type="text" name="name" class="easyui-textbox"
						data-options="required:true" /></td>
				</tr>
				<tr>
					<td>商品价格:</td>
					<td><input type="text" name="price"
						data-options="min:0,precision:2" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<td>生产日期:</td>
					<td><input type="text" name="productDate"
						class="easyui-datebox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>保质期:</td>
					<td><input type="text" name="expiration"
						class="easyui-numberbox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>厂商:</td>
					<td><input type="text" name="production"
						class="easyui-textbox" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>商品类别:</td>
					<td>
						<input id="updateGoodTypeCombox" name="goodTypeId">
    					</td>
				</tr>
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
	<script type="text/javascript" src="${base }/js/commerce/good.js"></script>
</html>