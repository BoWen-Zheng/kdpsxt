<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家查询</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.theme.min.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/Sj.js"></script>
<script type="text/javascript">
	$(function(){
		var sj=new Sj();
		sj.compageview("selectsj",{page:1},'#table','#nav');
	})
</script>
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
		<div class="col-xs-8">
		<div class="panel panel-default">
		  <div class="panel-heading"><h4>商家查询</h4></div>
			  <div class="panel-body">
			  		<table class="table table-striped">
						<tbody id="table">
							
						</tbody>
					</table>
					<div class="row">
						<div class="col-xs-6 col-xs-offset-3">
							<nav aria-label="Page navigation">
					  <ul class="pagination" id="nav">
					   
					  </ul>
					</nav>
						</div>
					</div>
					
			  </div>
		  </div>
		</div>
			
		
	</div>


</body>
</html>