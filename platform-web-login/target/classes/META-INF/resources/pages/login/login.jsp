<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录页面</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.css" />
<link href="/static/css/login.css" rel="stylesheet">

</head>
<body>
	<div id="errmsg" class="alert alert-danger" style="display: none;">${errmsg}</div>
	<div id="msg" class="alert alert-success" style="display: none;">${msg}</div>
	<div class="signin">
		<div class="signin-head">
			<img style="width: 120px; height: 120px;" src="/static/images/login_user.png" alt="test" class="rounded-circle">
		</div>
		<form class="form-signin" role="form" action="/login" method="post">
			<input type="text" class="form-control" id="username" name="username" value="${username}" placeholder="用户名" required autofocus />
			<input type="password" class="form-control" id="password" name="password" value="${password }" placeholder="密码" required />
			<button id="submitBtn" class="btn btn-lg btn-warning btn-block" type="submit">登录</button>


		</form>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
// 			console.log($("#errmsg").text());
			if ($("#errmsg").text() != '') {
				$("#errmsg").show();
			}
			if ($("#msg").text() != '') {
				$("#msg").show();
			}
			$("form").submit(function() {
				$("#submitBtn").html("正在处理...");
				$("#submitBtn").attr("disabled", "disabled");
			});
			$("#username").on('input propertychange', function() {
				$("#password").val("");
			});
		});
	</script>
</body>
</html>
