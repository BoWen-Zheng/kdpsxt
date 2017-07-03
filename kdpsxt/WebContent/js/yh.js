function Yh(){
	this.ajax=function(url,param){
		var promise=$.ajax({
			url:url,
			type:'POST',
			dataType:'json',
			data:{
				page:param,
				yhm:$("#yhm").val()
			}
		})
		return promise;
		
	}
	
	
	
	this.compagemain=function(id,yhs){
		var str="<tr><th>用户头像</th><th>用户名</th><th>学校</th><th>地址</th><th>电话</th></tr>";
		for(var i=0;i<yhs.length;i++){
				 str+='<tr><td><img style="width:80px;height:80px" src="'+yhs[i].tx+'"/></td><td>'+yhs[i].yhm+'</td><td>'+yhs[i].xx+'</td><td>'+yhs[i].wddz+'</td><td>'+yhs[i].wddh+'</td></tr>';	
			    
	}
		$(id).html(str); 
	}
	this.compageview=function(url,param,id,id2){
		This=this;
		var promise=this.ajax(url,param);
		promise.done(function(res){
			var pagecount=res.pagecount;
			console.log(pagecount);
			var arr=res.yhs;
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