$(function(){	//jsp资源加载完成时调用里面的代码
	$('#addGoodTypeWin').window('close');
	$('#updateGoodTypeWin').window('close');
//	$('#roleWin').window('close');
})
$('#goodTypeGrid').datagrid({
    url: base + '/commerce/goodType/pageGoodType',
    pagePosition:'bottom',
    pagination: true,
    singleSelect: true,
    fitColumns: true,
    toolbar: '#goodTypeGridToolBar',
    idField: "id",
    loadMsg: "正在努力为您加载数据",
    fit: true,
    rownumbers:true,
    nowrap: true,
    columns:[[
        {field:'name',title:'商品类型',width:100,sortable:true}
    ]]
});

function add() {
	$('#addGoodTypeForm').form('reset');
	$('#addGoodTypeWin').window("open");
};

function addClose() {
	$('#addGoodTypeWin').window('close');
};

function addSave() {
	if ($('#addGoodTypeForm').form('validate')) {
		$.ajax({
			type : "POST",
			url : base+ "/commerce/goodType/save",
			data : $('#addGoodTypeForm').serialize(),
			dataType : 'json',
			success : function(obj) {
				if (obj.code==0) {
					$('#addGoodTypeWin').window('close');
					var param = {};
				    generateCondition(param, $('#addGoodTypeForm').serialize());
				    param.id=obj.data
				    console.info(param);
					insertRowToGrid('goodTypeGrid', param);
					$('#addGoodTypeWin').window('close');
					pop('温馨提示', '保存成功');
				} else {
					pop('保存提示', obj.msg);
				}
			}
		});
	}
};

function update() {
	var row = $('#goodTypeGrid').datagrid('getSelected');
	if (row) {
		$('#updateGoodTypeWin').window("open");
		$('#updateGoodTypeForm').form('load', row);
	} else {
		pop('提示', "请选择要修改的数据！");
	}
};

function updateClose() {
	$('#updateGoodTypeWin').window('close');
};

function updateSave() {
	if ($('#updateGoodTypeForm').form('validate')) {
		$.ajax({
			type : "POST",
			url :  base + "/commerce/goodType/updateById",
			data : $('#updateGoodTypeForm').serialize(),
			dataType : 'json',
			success : function(obj) {
				if (obj.code==0) {
					$('#updateGoodTypeWin').window('close');
					var param = {};
				    generateCondition(param, $('#updateGoodTypeForm').serialize());
					updateRowInGrid('goodTypeGrid', param);
					pop('温馨提示', '保存成功');
				} else {
					pop('保存提示', obj.msg);
				}
			}
		});
	}
};

function del() {
	var row = $('#goodTypeGrid').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示信息', '确定删除?', function(r) {
			if (r) {
				$.ajax({
					type : "POST",
					dataType : 'json',
					url : base + "/commerce/goodType/removeById?id=" + row.id,
					success : function(obj) {
						if (obj.code==0) {
							deleteSelectedRow('goodTypeGrid');
							pop('温馨提示', '删除成功');
						} else {
							pop('删除提示', obj.msg);
						}
					}
				});
			}
		});
	} else {
		pop('删除提示', "请选择要删除的数据！");
	}
};
