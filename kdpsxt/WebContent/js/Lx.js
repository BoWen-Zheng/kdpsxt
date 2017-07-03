function Lx(){
	this.getpromise=function(){
		var promise=$.ajax({
			url:"checkupdatelx",
			type:"POST",
			dataType:'json',
			data:{
				pid:$("#select").val(),
				id:$("#id").val()
			}
		})
		return promise;
		
	}
	this.buttonclick=function(){
		This=this;
		$("#btn").on("click",function(){
			var promise=This.getpromise();

			promise.done(function(res){
				console.log(res);
				if(res){
					$("#form").submit();
				}
				else{
					$("#btn").before('<span class="text-danger">父类选择错误</span>');
				}
			})
			
			
		})
		
	}
	
	
	
}