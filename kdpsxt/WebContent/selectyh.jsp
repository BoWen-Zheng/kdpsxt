<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"
	href="css/bootstrap.theme.min.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />



<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/yh.js"></script>
<script type="text/javascript">
	$(function(){
		
		var yh=new Yh();
		yh.compageview("selectyh",1,'#table','#nav');
		$('#querybtn').on('click', function() {

			yh.compageview("selectyh",1,'#table','#nav');

		})
		
		
	})

</script>
<title>首页</title>
</head>
<body>


	<div>

		<div class="row">

			<div class="col-xs-12">


				<nav class="navbar navbar-default">
					<div class="container-fluid">


						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li><a href="#">快递配送管理系统</a></li>

							</ul>

							<ul class="nav navbar-nav navbar-right">
								<li><a href="outlogin">退出</a></li>

							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>

			</div>




		</div>


		<div class="row">


			<div class="col-xs-3">


				<%@include file="mouban.jsp"%>



			</div>


			<div class="col-xs-9">



				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">用户查询</h3>
					</div>
				<div class="panel-body">
					<form action="">
							<div class="row">
								<div class="form-group">
								<label class="col-xs-8 control-label">用户名称</label>
								<div class="col-xs-8">
									<input type="text" class="form-control" id="yhm" name="yhm" placeholder="请输入产品名称">
								</div>
								</div>
								<div class="col-xs-4" >
									<input style="width:100%" type="button" id="querybtn" value="查询" class="btn btn-danger">
								</div>
							</div>
					</form>
				
					<div class="row">

							<div class="col-xs-12">

								<table class="table table-bordered">

									<tbody id="table">



									</tbody>



								</table>




							</div>



						</div>



						<div class="row">

							<div class="col-xs-12" style="text-align: center">

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


			</div>






						


</body>
</html>