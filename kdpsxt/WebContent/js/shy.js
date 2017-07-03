function Shy(){
	this.ajax=function(url,param){
	
		var promise=$.ajax({
			url:url,
			type:'POST',
			dataType:'json',
			data:{
				page:param,
				xm:$("#xm").val()
			}
		})
		return promise;
		
	}
	this.compagemain=function(id,shys){
		
		var str="<tr><th>收货员姓名</th><th>收货员电话</th><th>收货员所在学校</th><th>收货员状态</th><th>操作</th></tr>";
		for(var i=0;i<shys.length;i++){
				 str+='<tr><td>'+shys[i].xm+'</td><td>'+shys[i].dh+'</td><td>'+shys[i].szxx+'</td><td>'+shys[i].zt+'</td><td><a href="updateshy?id='+shys[i].id+'" class="btn btn-default" style="margin-top:10px;">操作</a></td></tr>';	
			    
	}
		$(id).html(str); 
	}
	this.compageview=function(url,param,id,id2){
		This=this;
		
		var promise=this.ajax(url,param);
		promise.done(function(res){
			
			var pagecount=res.pagecount;
			
			var arr=res.shys;
			var nowpage=res.page;
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
				This.compageview(url,c,id,id2);
			}
			
			
		})
		$(id2+">li:last").on("click",function(){
			
			if(nowpage<pagecount){
				var c=nowpage+1;
				This.compageview(url,c,id,id2);
			}
			console.log(c);
			
		})
		
	}
	this.numbernav=function(url,id,id2){
		This=this;
		$(".numb").on("click",function(){
			
			 var c =  $('.numb').index($(this))+1;
			 This.compageview(url,c,id,id2);
			 $(this).arr("class","active");
		})
		
	}
		
	}