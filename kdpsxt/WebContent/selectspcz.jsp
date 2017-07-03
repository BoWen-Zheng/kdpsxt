<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/bootstrap.theme.min.css"/>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>

<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/bootstrap.min.js"></script>


<script type="text/javascript" src="ueditor/ueditor.config.js"></script>


<script type="text/javascript" src="ueditor/ueditor.all.min.js"></script>


<script type="text/javascript">


   $(function(){
	   
	   
	   var editor = UE.getEditor('container'); 
	   
	   
	   
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
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">后台管理系统</a></li>
       
      </ul>
    
      <ul class="nav navbar-nav navbar-right">
        <li><a href="outlogin">退出</a></li>
       
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
     
  </div>
   
   
   
   
   </div>
   
   
   <div class="row">
   
   
    <div class="col-xs-3">
    
    
    <%@include file="mouban.jsp" %>
    
    
    
    </div>
   
   
   	<div class="col-xs-9">
   	
   	
   	    
  <div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">产品添加</h3>
  </div>
  <div class="panel-body">
   
           					
 <form class="form-horizontal" action="addsp" method="POST" enctype="multipart/form-data">


<div id="jbxxid" class="xxk" style="margin-top:30px">

  <div class="form-group">
    <label   class="col-xs-3 control-label">产品名称</label>
    <div class="col-xs-9">
      <input type="text" class="form-control"  name="spmc" value="${requestScope.sp.spmc}">
    </div>
  </div>


	   

   <div class="form-group">
    <label   class="col-xs-3 control-label">产品详情</label>
    <div class="col-xs-9">
      <input type="text" class="form-control"  name="spxq" value="${requestScope.sp.spxq}">
    </div>
  </div>

  
      <div class="form-group">
    <label   class="col-xs-3 control-label">产品价格</label>
    <div class="col-xs-9">
      <input type="text" class="form-control"  name="spjg" value="${requestScope.sp.spjg}">
    </div>
  </div>
  
  
  
   <div class="form-group">
    <label   class="col-xs-3 control-label">产品主图</label>
    <div class="col-xs-9">
  <input type="file" class="form-control"  name="tp">
 
    </div>
  </div>
  
     <div class="form-group">
    <label   class="col-xs-3 control-label">选择商家</label>
    <div class="col-xs-9">
     
     <select class="form-control" name="sj" value="${requestScope.sp.sjid}">
     
     	<option value="0">--请选择--</option>
     	
     	<c:forEach items="${requestScope.sjs}" var="item">
     	
     	  <option value="${item.id}">${item.sjmc}</option>
     	
     	</c:forEach>
     
     </select>
 
    </div>
  </div>
  <div class="form-group">
    <label   class="col-xs-3 control-label">产品详情</label>
    <div class="col-xs-9">
      <script type="text/plain" id="container" name="spxq">

		   


         </script>
    </div>
  </div>
</div>
<button type="submit" class="btn btn-info" style="margin-top:30px;float:right">提交</button>	
</form>
  </div>
</div>  	
   	</div>   
   </div>
 
 
 </div>


</body>
</html>