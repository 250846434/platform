<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>主页面</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/webjars/bootstrap/css/bootstrap.min.css" />
<style>
* {
	margin: 0;
	padding: 0
}

html, body {
	height: 100%
}
</style>

</head>
<body>
	<input id="leftWidth" value="150" style="display: none;">
	<!-- 		<h1>登录框架主页！</h1> -->
	<%-- 		<a href="${pageContext.request.contextPath}/logout" class="btn btn-default">登出</a> --%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark navbar-static-top" id="top">
		<span class="navbar-brand mb-0 h1"><img src="/static/images/logo.jpg" width="30" height="30"
			class="d-inline-block align-top" alt="">登录框架主页</span>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/main">首页<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" id="a1" href="#">链接1</a></li>
				<%--<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Dropdown </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a></li> --%>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<nav id="nav" class="nav flex-column nav-pills">
		<a class="nav-link active" href="#">Active</a> 
		<a class="nav-link" href="#">Link</a> <a class="nav-link" href="#">Link</a>
		<a class="nav-link disabled" href="#">Disabled</a>
	</nav>
	<div id="con">123</div>

	<script src="<%=request.getContextPath()%>/webjars/jquery/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		//设置页面响应
		function resizePage(leftWidth) {
			var height = $(document.body).height()
					- $("#top").outerHeight(true);
			var width = $(document.body).width();
			// 			$('#top').offset({
			// 				top : 0,
			// 				left : 0
			// 			});
			// 			$("#top").height(100);
			// 			$("#top").width(width);

			// console.log("scrollTop:",$("body").scrollTop());
			// $("body").scrollTop(1)
			// console.log("scrollTop:",$("body").scrollTop());

// 			console.log("top:", $("#top").outerHeight(true));
			$('#nav').offset({
				top : $("#top").outerHeight(true),
				left : 0
			});
// 			console.log("left:", $("#nav").outerWidth(true));
			$("#nav").height(height);
			$("#nav").width(leftWidth);
// 			console.log("left:", $("#nav").outerWidth(true));
			$('#con').offset({
				top : $("#top").outerHeight(true),
				left : $("#nav").outerWidth(true)
			});
			$("#con").height(height);
			$("#con").width(width - leftWidth);
		}
		$(function() {
			$("#leftWidth").on('input propertychange', function() {
				console.log($("#leftWidth").val());
			});
// 			$("#leftWidth").val(190);
			var leftWidth=$("#leftWidth").val();
			resizePage(leftWidth);
			//当浏览器大小变化时
			$(window).resize(function() {
				resizePage(leftWidth);
			});
			// 			页面加载的时候，内容框默认显示 a.html
			$('#con').load('/pages/menu1.jsp');
			// 			单击 a 链接，加载 a.html
			$("#a1").click(function() {
				$("#leftWidth").val(190);
				
				$('#con').load('/pages/menu1.jsp');
				
			});
			//单击 b 链接，加载 b.html
			$("#a2").click(function() {
				$('#con').load('/pages/menu2.jsp');
			});
		})
	</script>
</body>
</html>
