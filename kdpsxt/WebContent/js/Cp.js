function Cp(){
	
	
	
	this.querycpurl = "selectsp";
	
	
	
	this.getPromise = function(spmc,beginjg,endjg,sjid,curpage){
		
		var This = this;
		
		var promise = $.ajax({
			
			url:This.querycpurl,
			
			dataType:'json',
			
			type:'post',
			
			data:{
				
				spmc:spmc,
				
				beginjg:beginjg,
				
				endjg:endjg,
				
				sjid:sjid,
				page:curpage
				
				}
			
			
			
		});
		
		
		return promise;
		
		
	}
	
	
	this.ListnerQuery = function(){
		
		
		var This = this;
		
		
		$('#querybtn').on('click',function(){
			
			
			This.ComPageTable(1);
			
			
			
			
		})
		
		
		
	}
	
	
	this.ComPageTable = function(curpage){
		
		
		var This = this;
		
		
		var beginjg = $('#beginjgid').val();
		
		
		
		var endjg = $('#endjgid').val();
		
		
		var sjid=$("#sjid").val();
		var cpmc = $('#cpmcid').val();
		
		var sjid=$('#sjid').val();
		console.log(beginjg);
		console.log(endjg);
		console.log(cpmc);
		console.log(sjid);
		console.log(curpage);
		var promise = this.getPromise(cpmc,beginjg,endjg,sjid,curpage);
		
		
		promise.done(function(data){
				
			
			   var cps = data.sps;
			   
			   var pagecount = data.pagecount;
			   
			   var curpage = data.page;
			   
			   
			   This.comPageNav(pagecount,curpage);
			   This.comTable(cps);
			   
			   This.ListenerNb();
			   
			   This.ListenerNlAndNr(curpage,pagecount);
			
			
			
			
			
			
		})
		
		
		
		
	}
	
	this.ListenerNb = function() {
		var This = this;

		$('.nb').on('click', function() {

			var c = $('.nb').index($(this)) + 1;

			This.ComPageTable(c);

		})

	}
	
	
	this.ListenerNlAndNr = function(currpage, pagecounts) {

		var This = this;

		$("#nl").on('click', function() {

			if (currpage > 1) {

				var c = --currpage;

				This.ComPageTable(c);

			}

		})

		$("#nr").on('click', function() {

			if (currpage < pagecounts) {

				var c = ++currpage;

				This.ComPageTable(c);

			}

		})

	}
	
	
	this.comPageNav = function(pagecount,currpage){
		
		
		var str = "";

		str += '<li>' + '<a href="#" aria-label="Previous" id="nl">'
				+ '<span aria-hidden="true">&laquo;</span>' + '</a>' + '</li>';

		for (var i = 1; i <= pagecount; i++) {

			if (i == currpage) {

				str += '<li class="active nb"><a href="#">' + i + '</a></li>';

			}

			else {
				str += '<li class="nb"><a href="#">' + i + '</a></li>';
			}

		}

		str += '<li>' + '<a href="#" aria-label="Next" id="nr">'
				+ '<span aria-hidden="true">&raquo;</span>' + '</a>' + '</li>';
		
		$('#nav').html(str);
		
	}
	
	this.comTable = function(cps){
		
		
		var str = "";

		str += '<tr>' +

		'<th>产品图片</th>' +

		'<th>产品名称</th>' +
		
		'<th>产品价格</th>' +

		'<th>商家</th>' +
		
		'<th>操作</th>' +
		
		'</tr>';
		
	for(var i=0;i<cps.length;i++){
		
		var ob = cps[i];
		
		var cptp = ob.tp;
		
		var cpmc = ob.spmc;
		
		var cpjg = ob.spjg;
		
		var lstr = "";		
		
		var sjmc = ob.sj.sjmc;
		
		
		str += '<tr>' +

		'<td>'+'<img src="'+cptp+'">'+'</td>' +

		'<td>'+cpmc+'</td>' +
		
		'<td>'+cpjg+'</td>' +
		
		'<td>'+sjmc+'</td>' +
		
	
		'<td><a href="selectonesp?id=' + ob.id+ '" class="btn btn-warning" >操作</a></td>' +
		
		'</tr>';
		
		
		
		
		
		
	}
	
	$("#cpdata").html(str);
		

		
		
		
		
		
	}
	
	
}