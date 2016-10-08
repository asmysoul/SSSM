<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="common/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
    <%@ include file="common/basejs.jsp" %>

<title>后台登录</title>
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  
//回车登录
});
</script>
<style type="text/css">
.tb960x90 {display:none!important;display:none}</style>
</head>
<body >
<dl class="admin_login">
 <dt>
  <strong>站点后台</strong>
  <em>Management System</em>
 </dt>
 <form id="loginForm" method="post">
 <dd class="user_icon">
  <input type="text" name="loginname" id="loginname" placeholder="请输入账号" class="login_txtbx"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" name="password" id="password" placeholder="请输入密码" class="login_txtbx"/>
 </dd>
 <dd>
  <input type="submit" value="立即登陆" class="submit_btn" id="submitbtn"/>
 </dd>
 </form>
</dl>
</body>
    <script src="${staticPath}/resource/js/login.js" type="text/javascript"></script>
</html>
