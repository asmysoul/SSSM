<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="../common/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="../common/basejs.jsp" %>
    <script type="text/javascript">
    var dataGrid;
    	$(function(){
    		
    		    $(function() {
    		        dataGrid = $('#dataGrid').datagrid({
    		            url : '${path }' + '/role/roleData',
    		            striped : true,
    		            rownumbers : true,
    		            pagination : true,
    		            singleSelect : true,
    		            idField : 'id',
    		            sortName : 'id',
    		            sortOrder : 'asc',
    		            pageSize : 20,
    		            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
    		            frozenColumns : [ [ {
    		                width : '100',
    		                title : 'id',
    		                field : 'id',
    		                sortable : true
    		            }, {
    		                width : '80',
    		                title : '名称',
    		                field : 'name',
    		                sortable : true
    		            } , {
    		                width : '80',
    		                title : '排序号',
    		                field : 'seq',
    		                sortable : true
    		            }, {
    		                width : '200',
    		                title : '描述',
    		                field : 'description'
    		            } , {
    		                width : '60',
    		                title : '状态',
    		                field : 'status',
    		                sortable : true,
    		                formatter : function(value, row, index) {
    		                    switch (value) {
    		                    case 0:
    		                        return '正常';
    		                    case 1:
    		                        return '停用';
    		                    }
    		                }
    		            }, {
    		                field : 'action',
    		                title : '操作',
    		                width : 200,
    		                formatter : function(value, row, index) {
    		                    var str = '';
    		                        <shiro:hasPermission name="/role/grant">
    		                            str += '<a href="javascript:void(0)" class="role-easyui-linkbutton-ok" data-options="plain:true,iconCls:\'icon-ok\'" onclick="grantFun(\''+ row.id + '\');" >授权</a>';
    		                        </shiro:hasPermission>
    		                        <shiro:hasPermission name="/role/edit">
    		                            str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
    		                            str += '<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\''+ row.id + '\');" >编辑</a>';
    		                        </shiro:hasPermission>
    		                        <shiro:hasPermission name="/role/delete">
    		                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
		                            str += '<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-remove\'" onclick="editFun(\''+ row.id + '\');" >删除</a>';
    		                        </shiro:hasPermission>
    		                    return str;
    		                }
    		            } ] ],
    		            onLoadSuccess:function(data){
    		                $('.role-easyui-linkbutton-ok').linkbutton({text:'授权',plain:true,iconCls:'icon-ok'});
    		                $('.role-easyui-linkbutton-edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
    		                $('.role-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
    		            },
    		            toolbar : '#toolbar'
    		        });
    		    });
    	});
    	
    	function closeAuthDialog(){
    		$("#grantDialog").dialog("close");
    	}
    	
    	var roleId;
    	
    	function grantFun(id) {
	        if (id == undefined) {
	            var rows = dataGrid.datagrid('getSelections');
	            id = rows[0].id;
	        } else {
	            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
	        }	        
	        $('#grantDialog').dialog("open").dialog("setTitle","角色授权");
	        roleId = id;
	        var resourceTree = $("#grantTree").tree({
				lines:true,
				url: realpath+ "/role/findAllTree",
				checkbox:true,
				cascadeCheck:false,
				onLoadSuccess:function(node, data){
					 $.post( realpath+ '/role/findResourceIdListByRoleId', {
		                    id : id
		                }, function(result) {
		                    var ids = result.data;
		                    if (ids.length > 0) {
		                        for ( var i = 0; i < ids.length; i++) {
		                            if (resourceTree.tree('find', ids[i])) {
		                                resourceTree.tree('check', resourceTree.tree('find', ids[i]).target);
		                            }
		                        }
		                    }
		                }, 'json');
				}
			});
	    }
    	
    	function saveAuth(){
    		var nodes=$('#grantTree').tree('getChecked');
    		var authArrIds=[];
    		for(var i=0;i<nodes.length;i++){
    			authArrIds.push(nodes[i].id);
    		}
    		var resourceIds=authArrIds.join(",");
    		$.post(realpath + "/role/updateAuthorization",{roleId:roleId, resourceIds:resourceIds},function(result){
    			if(result.success){
    				$.messager.alert('系统提示','授权成功！');
    				closeAuthDialog();
    			}else{
    				$.messager.alert('系统提示',result.errorMsg);
    			}
    		},"json");
    	}
    </script>
</head>
<body class="easyui-layout">
	 <div data-options="region:'center',fit:true,border:false">
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
        <shiro:hasPermission name="/role/add">
            <a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
        </shiro:hasPermission>
    </div>
    <div id="grantDialog"class="easyui-dialog" style="width: 500px;height: 550px;padding: 10px 20px"
  	closed="true" buttons="#grant-buttons">
		<ul id="grantTree" class="easyui-tree"></ul>
	</div>
	<div id="grant-buttons">
	<a href="javascript:saveAuth()" class="easyui-linkbutton" iconCls="icon-ok" >授权</a>
	<a href="javascript:closeAuthDialog()" class="easyui-linkbutton" iconCls="icon-cancel" >关闭</a>
</div>
</body>
<script type="text/javascript" src="${staticPath }/resource/js/role.js"></script>
</html>