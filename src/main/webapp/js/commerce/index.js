$(function(){
	$('#addGoodWin').window('close');
	$('#updateGoodWin').window('close');
	$('#roleWin').window('close');
})

$('#goodGrid').datagrid({
    url: base + '/commerce/good/pageGood',
    pagePosition:'bottom',
    pagination: true,
    singleSelect: true,
    fitColumns: true,
    toolbar: '#goodGridToolBar',
    idField: "id",
    loadMsg: "正在努力为您加载数据",
    fit: true,
    rownumbers:true,
    nowrap: true,
    columns:[[
        {field:'name',title:'商品名称',width:100,sortable:true},
        {field:'price',title:'商品价格',width:100,sortable:true},
        {field:'productDate',title:'生产日期',width:100,sortable:true},
        {field:'expiration',title:'保质期',width:80,align:'center',
            formatter:function(value,row,index){
            		return value + "天";
            }
        },
        {field:'production',title:'厂商',width:100,sortable:true},
        {field:'goodTypeName',title:'商品类别名称',width:100,sortable:true}
    ]]
});

function add() {
	$('#addGoodForm').form('reset');
	$('#addGoodWin').window("open");
};

function addClose() {
	$('#addGoodWin').window('close');
};
function updateClose() {
	$('#updateGoodWin').window('close');
};

function addSave() {
	if ($('#addGoodForm').form('validate')) {
		$.ajax({
			type : "POST",
			url : base+ "/commerce/good/save",
			data : $('#addGoodForm').serialize(),
			dataType : 'json',
			success : function(obj) {
				if (obj.code==0) {
					$('#addGoodWin').window('close');
					var param = {};
				    generateCondition(param, $('#addGoodForm').serialize());
				    param.id=obj.data
				    console.info(param);
					insertRowToGrid('goodGrid', param);
					$('#addGoodWin').window('close');
					pop('温馨提示', '保存成功');
				} else {
					pop('保存提示', obj.msg);
				}
			}
		});
	}
};

function updateSave() {
	if ($('#updateGoodForm').form('validate')) {
		$.ajax({
			type : "POST",
			url :  base + "/commerce/good/updateById",
			data : $('#updateGoodForm').serialize(),
			dataType : 'json',
			success : function(obj) {
				if (obj.code==0) {
					$('#updateGoodWin').window('close');
					var param = {};
				    generateCondition(param, $('#updateGoodForm').serialize());
					updateRowInGrid('goodGrid', param);
					pop('温馨提示', '保存成功');
				} else {
					pop('保存提示', obj.msg);
				}
			}
		});
	}
};

function update() {
	var row = $('#goodGrid').datagrid('getSelected');
	if (row) {
		$('#updateGoodWin').window("open");
		$('#updateGoodForm').form('load', row);
	} else {
		pop('提示', "请选择要修改的数据！");
	}
};

function del() {
	var row = $('#goodGrid').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示信息', '确定删除?', function(r) {
			if (r) {
				$.ajax({
					type : "POST",
					dataType : 'json',
					url : base + "/commerce/good/removeById?id=" + row.id,
					success : function(obj) {
						if (obj.code==0) {
							deleteSelectedRow('goodGrid');
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

