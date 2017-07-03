<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body a{
 text-decoration:none;
}
</style>
</head>
<body>
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        	用户管理
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
      		<div class="list-group">
			 
			  <a href="selectyh.jsp" class="list-group-item">用户查询</a>
			</div>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
         	商家管理
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
			<div class="list-group">
			  <a href="addsj.jsp" class="list-group-item">商家添加</a>
			  <a href="selectsj.jsp" class="list-group-item">商家查询</a>
			</div>
      </div>
    </div>
  </div>
    <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          	收货员管理
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
     		<div class="list-group">
			  <a href="addshy.jsp" class="list-group-item">收货员添加</a>
			  <a href="selectshy.jsp" class="list-group-item">收货员查询</a>
			</div>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFree" aria-expanded="false" aria-controls="collapseFree">
          	商品管理
        </a>
      </h4>
    </div>
    <div id="collapseFree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFree">
      <div class="panel-body">
     		<div class="list-group">
			  <a href="selectlxtosp" class="list-group-item">商品添加</a>
			  <a href="selectcp" class="list-group-item">商品查询</a>
			</div>
      </div>
    </div>
  </div>
</div>
	
</body>
</html>