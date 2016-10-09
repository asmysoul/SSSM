<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="../common/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="../common/basejs.jsp" %>
    <script type="text/javascript">
    	$(function(){
    		 var dataGrid;
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
    		                            str += '<a href="javascript:void(0)" class="role-easyui-linkbutton-ok" data-options="plain:true,iconCls:\'icon-ok\'" onclick="grantFun(\'{0}\');" >授权</a>';
    		                        </shiro:hasPermission>
    		                        <shiro:hasPermission name="/role/edit">
    		                            str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
    		                            str += '<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>';
    		                        </shiro:hasPermission>
    		                        <shiro:hasPermission name="/role/delete">
    		                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
		                            str += '<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >删除</a>';
    		                        </shiro:hasPermission>
    		                    return str;
    		                }
    		            } ] ],
    		            onLoadSuccess:function(data){
    		                $('.role-easyui-linkbutton-ok').linkbutton({text:'授权',plain:true,iconCls:'icon-ok'});
    		                $('.role-easyui-linkbutton-edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
    		                $('.role-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-del'});
    		            },
    		            toolbar : '#toolbar'
    		        });
    		    });
    	});
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
</body>
<script type="text/javascript" src="${staticPath }/resource/js/role.js"></script>
</html>