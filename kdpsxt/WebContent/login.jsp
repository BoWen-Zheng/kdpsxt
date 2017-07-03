<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.theme.min.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	
		
			
</script>	
</head>
<body style="background:rgba(0,0,0,0.5)">
	<div class="container">
		<div class="row" style="margin-top:150px">
			<div class="col-xs-6 col-xs-offset-3">
				<div class="panel panel-info">
					 <div class="panel-heading">后台登录</div>
					  <div class="panel-body">
					    <div class="row">
						<div class="col-xs-12">
							<form class="form-horizontal" action="login" method="POST">
								<div class="input-group" style="margin-top:30px">	
								  <span class="input-group-addon" id="sizing-addon2">用户名</span>
								  <input type="text" class="form-control" placeholder="请输入用户名" name="yhm" aria-describedby="sizing-addon2" id="name">
								</div>

								<div class="input-group" style="margin-top:30px">
								  <span class="input-group-addon" id="sizing-addon2">密&nbsp;&nbsp;&nbsp;码</span>
								  <input type="password" class="form-control" placeholder="请输入密码" name="yhmm" aria-describedby="sizing-addon2" id="password">
								</div>
								<div class="row">
								  	<div class="col-xs-12" style="margin-top:30px">
								  		 <c:if test="${param['flag']==true}">
								  			<div class="alert alert-danger" role="alert">用户名或密码输入错误</div>
								  		 </c:if>
								  	</div>
								  </div>
								<div class="row" style="margin-top:30px">
								<div class="col-xs-offset-10"><button type="submit" class="btn btn-info">登录</button></div>
								</div>
							</form>	
						</div>
					</div>
					  </div>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>