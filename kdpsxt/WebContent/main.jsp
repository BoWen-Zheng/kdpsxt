<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.theme.min.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
	<div class="col-xs-12">
		<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">快递配送管理系统</a>
    </div>

   		<!-- Standard button -->
		<a href="outlogin" class="btn btn-default" style="margin-top:10px;float:right">退出</a>
    </div><!-- /.navbar-collapse -->
</nav>
	</div>
</div>
	

	<div class="row">
		<div class="col-xs-3">
		<%@include file="mouban.jsp" %>
		</div>
		<div class="col-xs-9">
			<div class="jumbotron">
			  <h1>欢迎来到快递配送后台管理系统</h1>
			</div>
		</div>
	</div>


</body>
</html>