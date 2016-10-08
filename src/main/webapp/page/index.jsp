<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="common/global.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="common/basejs.jsp" %>
    <script type="text/javascript">
    function logout(){
        $.messager.confirm('提示','确定要退出?',function(r){
            if (r){
                $.post('${path }/logout', function(result) {
                    if(result.success){
                        window.location.href='${path }';
                    }
                }, 'json');
            }
        });
    }
    </script>
<title>首页</title>
</head>
<body class="easyui-layout">
	 <div id="loading" style="position: fixed;top: -50%;left: -50%;width: 200%;height: 200%;background: #fff;z-index: 100;overflow: hidden;">
        <img src="${staticPath }/resource/image/loading.gif" style="position: absolute;top: 0;left: 0;right: 0;bottom: 0;margin: auto;"/>
    </div>
	  <div data-options="region:'north',border:false" style=" overflow: hidden; height:46px; background: #2d3e50;">
            <div>
            	<span style="padding-left: 20px; margin-top: 15px; color: #fff;font-size:15px;"><a href="http://www.fzqblog.top" target="_blank" class="lightfont">java交流博客____www.fzqblog.top</a></span>
                <span style="float: right; padding-right: 20px; margin-top: 15px; color: #fff;font-size:15px;">欢迎 <b><shiro:principal></shiro:principal></b>&nbsp;&nbsp; <a href="javascript:void(0)" onclick="logout()" class="easyui-linkbutton" style="margin-top: -3px;color:#fff;font-size:15px;" plain="true" icon="icon-clear">安全退出</a></span>
            </div>
        </div>
    <div data-options="region:'west',title:'菜单',split:true" style="width: 160px; overflow: hidden;overflow-y:auto; padding:0px;margin:0;">
    		<ul id="tt" class="easyui-tree">
    <li>
        <span>Folder</span>
        <ul>
		            <li>
		                <span>Sub Folder 1</span>
		                <ul>
		                    <li><span><a href="#">File 11</a></span></li>
		                    <li><span>File 12</span></li>
		                    <li><span>File 13</span></li>
		                </ul>
		            </li>
		            <li><span>File 2</span></li>
		            <li><span>File 3</span></li>
		        </ul>
		    </li>
		    <li><span>File21</span></li>
		</ul>	    		
    </div>
    <div data-options="region:'center',title:''" style="overflow: hidden;padding:0;margin:0;">
			<div id="tt" class="easyui-tabs" data-options="fit:true">
			    <div title="首页" data-options="border:false"  style="overflow: hidden;">
			        <iframe src="http://www.fzqblog.top" frameborder="0"  style="border:0;width:100%;height:100%;">
			        </iframe>
			    </div>
			</div>
    </div>
</body>
<script type="text/javascript" src="${staticPath }/resource/js/index.js"></script>
</html>