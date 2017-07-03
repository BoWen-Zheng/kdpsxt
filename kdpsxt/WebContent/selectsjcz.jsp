<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商家</title>
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
      <a class="navbar-brand" href="#">必要管理系统</a>
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
		<div class="col-xs-8">
		<div class="panel panel-default">
		  <div class="panel-heading"><h4>商家修改</h4></div>
		  <div class="panel-body">
		  	<form action="updatesjcz" class="form-group" method="POST" enctype="multipart/form-data">
		  	<input type="hidden" class="form-control" id="id" name="id" value="${param['id']}">
		      <div class="form-group">
			    <label for="exampleInputPassword1">商家名称</label>
			    <input type="text" class="form-control" id="sjmc" value="${requestScope.sj.sjmc}" name="sjmc">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputFile">商家图片</label>
			    <input type="file" id="tp" name="tp">
			    <p class="help-block">从这里上传您的商家图片</p>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">商家地址</label>
			    <input type="text" class="form-control" id="sjdz"  value="${requestScope.sj.sjdz}" name="sjdz">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">商家电话</label>
			    <input type="text" class="form-control" id="sjdh" value="${requestScope.sj.sjdh}" name="sjdh">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">配送时间</label>
			    <input type="text" class="form-control" id="pssj" value="${requestScope.sj.pssj}" name="pssj">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">配送方式</label>
			    <input type="text" class="form-control" id="psfs" value="${requestScope.sj.psfs}" name="psfs">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">起始价格</label>
			    <input type="text" class="form-control" id="qsjg" value="${requestScope.sj.qsjg}" name="qsjg">
			  </div>
			   <div class="form-group">
			    <label for="exampleInputPassword1">人均价格</label>
			    <input type="text" class="form-control" id="rjjg" value="${requestScope.sj.rjjg}" name="rjjg">
			  </div>
			   <div class="form-group">
			    <label for="exampleInputPassword1">详情</label>
			    <input type="text" class="form-control" id="xq" value="${requestScope.sj.xq}"  name="xq">
			  </div>
			  <c:if test="${param['flag']==false }">
			  <div class="alert alert-danger" role="alert">对不起，修改失败</div>
			  </c:if>
			  <c:if test="${param['flag']==true }">
			  <div class="alert alert-success" role="alert">修改成功！</div>
			  </c:if>
			  
			<button type="submit" class="btn btn-info" style="margin-top:30px;float:right">提交</button>	
			</form>
		</div>
		  </div>
		</div>
			
		
	</div>


</body>
</html>