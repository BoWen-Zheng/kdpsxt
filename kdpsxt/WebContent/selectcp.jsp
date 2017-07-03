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

<script type="text/javascript" src="js/Cp.js"></script>
<script type="text/javascript">
	
	$(function(){var sp=new Cp();
	sp.ComPageTable(1);
	
	$('#querybtn').on('click',function(){
		
		
		sp.ComPageTable(1);
	})
	})
</script>



<style>
#cpdata img {
	width: 80px;
	height: 80px;
}
</style>




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
								<li><a href="#">快递配送后台管理系统</a></li>

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
						<h3 class="panel-title">商品查询</h3>
					</div>
					<div class="panel-body">


						
				<form action="" class="form-horizontal">
				<div class="form-group">
				
			
								<label class="col-xs-2 control-label">价格区间</label>
								<div class="col-xs-4">
									<input type="text" class="form-control" id="beginjgid" name="beginjg">
								</div>
								
								<label class="col-xs-2 control-label" style="text-align: center">至</label>
								
								
								<div class="col-xs-4" >
									<input type="text" class="form-control" id="endjgid" name="endjg">
								</div>
								
								
							</div>
									<div class="form-group">
										<label class="col-xs-2 control-label">产品名称</label>
										<div class="col-xs-2">
											<input type="text" class="form-control" id="cpmcid"
												name="sjmc" placeholder="请输入产品名称">
										</div>

										
										
										
											<label class="col-xs-2 control-label">选择商家</label>
										<div class="col-xs-2">
											
											<select name="sj" id="sjid" class="form-control">
											
												<option value="0">--请选择--</option>
											
											 	<c:forEach items="${requestScope.sjs}" var="item">
											 	
											 		<option value="${item.id}">${item.sjmc}</option>
											 	
											 	
											 	</c:forEach>
											
											
											
											</select>
											
										</div>



									</div>
									
									
									
						
									

							
									<div class="col-xs-4" >
									
									  <input style="width:100%" type="button" id="querybtn" value="查询" class="btn btn-danger">
								</div>
							
							


								</form>
								<div class="row">

							<div class="col-xs-12">

								<table class="table table-bordered">

									<tbody id="cpdata">



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