function Sj(){
	this.ajax=function(url,param){
		var promise=$.ajax({
			url:url,
			type:'POST',
			dataType:'json',
			data:param
		})
		return promise;
		
	}
	this.compagemain=function(id,sjs){
		var str="<tr><th>ID</th><th>商家名称</th><th>商家图片</th><th>商家地址</th><th>商家电话</th><th>配送时间</th><th>起始价格</th><th>人均价格</th><th>详情</th><th>操作</th></tr>";
		for(var i=0;i<sjs.length;i++){
				 str+='<tr><td>'+(i+1)+'</td><td>'+sjs[i].sjmc+'</td><td><img style="width:80px;height:80px" src="'+sjs[i].tp+'"/></td><td>'+sjs[i].sjdz+'</td><td>'+sjs[i].sjdh+'</td><td>'+sjs[i].pssj+'</td><td>'+sjs[i].qsjg+'</td><td>'+sjs[i].rjjg+'</td><td>'+sjs[i].xq+'</td><td><a href="updatesj?id='+sjs[i].id+'" class="btn btn-default" style="margin-top:10px;">操作</a></td></tr>';	
			    
	}
		$(id).html(str); 
	}
	this.compageview=function(url,param,id,id2){
		This=this;
		var promise=this.ajax(url,param);
		promise.done(function(res){
			var pagecount=res.pagecount;
			console.log(pagecount);
			var arr=res.sjs;
			var nowpage=res.nowpage;
			This.compagemain(id,arr);
			This.compagenav(id2,pagecount,nowpage);
			This.navclick(url,nowpage,id,id2,pagecount);
			This.numbernav(url,id,id2);
		})
		
		
	}
	this.compagenav=function(id,pagecount,nowpage){
		var str='<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
	    for(var i=0;i<pagecount;i++){
	    	if((i+1)==nowpage){
	    		str+='<li class="active numb"><a href="#">'+(i+1)+'</a></li>';
	    	}
	    	else{
	    		str+='<li class="numb"><a href="#">'+(i+1)+'</a></li>';
	    	}
	    }
		str+='<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
	    $(id).html(str);
		
	}
	this.navclick=function(url,nowpage,id,id2,pagecount){
		This=this;
		$(id2+">li:first").on("click",function(){
			if(nowpage>1){
				var c =nowpage-1;
				This.compageview(url,{page:c},id,id2);
			}
			
			
		})
		$(id2+">li:last").on("click",function(){
			
			if(nowpage<pagecount){
				var c=nowpage+1;
				This.compageview(url,{page:c},id,id2);
			}
			console.log(c);
			
		})
		
	}
	this.numbernav=function(url,id,id2){
		This=this;
		$(".numb").on("click",function(){
			
			 var c =  $('.numb').index($(this))+1;
			 This.compageview(url,{page:c},id,id2);
			 $(this).arr("class","active");
		})
		
	}
		
	}