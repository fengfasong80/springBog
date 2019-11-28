$(function(){
	$('#addAdminWin').window('close');
	$('#updateAdminWin').window('close');
	$('#roleWin').window('close');
})

$('#adminGrid').datagrid({
    url: base+'/right/admin/page',
    pagePosition:'bottom',
    pagination: true,
    singleSelect: true,
    fitColumns: true,
    toolbar: '#adminGridToolBar',
    idField: "id",
    loadMsg: "正在努力为您加载数据",
    fit: true,
    rownumbers:true,
    nowrap: true,
    columns:[[
        {field:'username',title:'用户名',width:100,sortable:true},
        {field:'realname',title:'真实姓名',width:100,sortable:true},
        {field:'id',title:'其它操作',width:80,align:'center',
            formatter:function(value,row,index){
            	var roleManage = '<a href="javascript:void(0)" onclick="showMenu(\''+row.id+'\')">角色管理</a> ';
            	return roleManage;
            }
        }
    ]]
});

function add() {
	$('#addAdminForm').form('reset');
	$('#addAdminWin').window("open");
};

function addClose() {
	$('#addAdminWin').window('close');
};
function updateClose() {
	$('#updateAdminWin').window('close');
};

function addSave() {
	if ($('#addAdminForm').form('validate')) {
		$.ajax({
			type : "POST",
			url : base+"/right/admin/save",
			data : $('#addAdminForm').serialize(),
			dataType : 'json',
			success : function(obj) {
				if (obj.code == 0) {
					$('#addAdminWin').window('close');
					var param = {};
				    generateCondition(param, $('#addAdminForm').serialize());
				    param.id=obj.data.id
				    console.info(param);
					insertRowToGrid('adminGrid', param);
					pop('温馨提示', '保存成功');
				} else {
					pop('保存提示', obj.msg);
				}
			}
		});
	}
};

function updateSave() {
	if ($('#updateAdminForm').form('validate')) {
		$.ajax({
			type : "POST",
			url : base+"/right/admin/update",
			data : $('#updateAdminForm').serialize(),
			dataType : 'json',
			success : function(obj) {
				if (obj.code == 0) {
					$('#updateAdminWin').window('close');
					var param = {};
				    generateCondition(param, $('#updateAdminForm').serialize());
				    param.id=obj.data.id
					updateRowInGrid('adminGrid', param);
					pop('温馨提示', '保存成功');
				} else {
					pop('保存提示', obj.msg);
				}
			}
		});
	}
};

function update() {
	var row = $('#adminGrid').datagrid('getSelected');
	if (row) {
		$('#updateAdminWin').window("open");
		$('#updateAdminForm').form('load', row);
	} else {
		pop('提示', "请选择要修改的数据！");
	}
};

function del() {
	var row = $('#adminGrid').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示信息', '确定删除?', function(r) {
			if (r) {
				$.ajax({
					type : "POST",
					url : base+"/right/admin/delete?id=" + row.id,
					dataType: "JSON",
					success : function(obj) {
						if (obj.code == 0) {
							deleteSelectedRow('adminGrid');
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

function showMenu(adminId){
	$('#roleWin').window('open');
	$('#role').datagrid({
	    url: base+'/right/role/pageByAdminId?adminId=' + adminId,
	    pagePosition:'bottom',
	    pagination: true,
	    singleSelect:false,
	    fitColumns: true,
	    idField: "id",
	    loadMsg: "正在努力为您加载数据",
	    fit: true,
	    rownumbers:true,
	    nowrap: true,
	    columns:[[
	        {field:'id',title:'选择',checkbox:true},
	        {field:'code',title:'角色名',width:100,sortable:true},
	        {field:'name',title:'角色代码',width:100,sortable:true}
	    ]],
	    onLoadSuccess:function(data){ 
	        var rows = data.rows;
	        $("#role").datagrid("clearChecked"); 
	        $.each(rows,function(index,row){   
	            if(row.count>0){    
	                $("#role").datagrid("selectRecord", row.id);  
	            }
	        });  
	    }
	})
}


$("#closeMenuWin").click(function(){
	$('#roleWin').window('close');
});

$("#saveMenuSbmt").click(function(){
	var admin = getSelectedRow('adminGrid');
	var roles = $("#role").datagrid("getChecked");
	var roleIds=new Array()
	for (var i=0;i<roles.length;i++){
		roleIds[i] = roles[i].id
	}
	var relationData = {};
	relationData["adminId"] = admin.id
	relationData["roleIds"] = roleIds;
	$.ajax({
		type : "POST",
		async : false,
		url : base+"/right/adminRole/save",
		data : relationData,
		dataType : 'json'
	});
	pop('温馨提示', '保存成功');
	$("#roleWin").window("close");
});
