<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加收货员</title>
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
      <a class="navbar-brand" href="#">快递配送系统管理系统</a>
    </div>

   		<!-- Standard button -->
		<a src="outlogin" class="btn btn-default" style="margin-top:10px;float:right">退出</a>
    </div><!-- /.navbar-collapse -->
</nav>
	</div>
</div>
	

	<div class="row">
		<div class="col-xs-3">
		<%@include file="mouban.jsp" %>
		</div>
		<div class="col-xs-8">
		<div class="panel panel-default">
		  <div class="panel-heading"><h4>收货员添加</h4></div>
		  <div class="panel-body">
		  	<form action="addshy" class="form-group" method="POST">
		      <div class="form-group">
			    <label for="exampleInputPassword1">收货员名称</label>
			    <input type="text" class="form-control" id="xm" placeholder="请输入您的收货员名称" name="xm">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">收货员电话</label>
			    <input type="text" class="form-control" id="dh" placeholder="请输入您的收货员电话" name="dh">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">所在学校</label>
			    <input type="text" class="form-control" id="szxx" placeholder="请输入您的所在地址" name="szxx">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">状态</label>
			    <input type="radio" id="zt" value="0" name="zt">工作
			    <input type="radio" id="zt" value="1" name="zt">休息
			  </div>
			  
			  <c:if test="${param['flag']==false }">
			  <div class="alert alert-danger" role="alert">对不起，添加失败</div>
			  </c:if>
			  <c:if test="${param['flag']==true }">
			  <div class="alert alert-success" role="alert">添加成功！</div>
			  </c:if>
			  
			<button type="submit" class="btn btn-info" style="margin-top:30px;float:right">提交</button>	
			</form>
		</div>
		  </div>
		</div>
			
		
	</div>


</body>
</html>