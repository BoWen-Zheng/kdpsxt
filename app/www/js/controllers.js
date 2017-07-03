angular.module('Mycontroller', ['ionic','MyService','ngCordova','jett.ionic.filter.bar'])
.controller('CNTR',function($scope,$ionicModal,$ionicActionSheet,$timeout,$window,$cordovaCamera,$cordovaImagePicker,myservice,$cordovaFileTransfer) {


  $scope.localimage = "";
   $scope.id=localStorage.getItem('id');
  $ionicModal.fromTemplateUrl("js/template/uploadtx.html", {
  scope: $scope,
      animation: "slide-in-up"
}).then(function(modal) {
  $scope.modal = modal;
});




var showModel=function(){

    $scope.modal.show();

   }


   $scope.hideModel=function(){

    $scope.localimages="";

     $scope.modal.hide();

   }


      $scope.sendDD = function(){

      

      

        var ob = $scope.localimage;

        var id= $scope.id;


       

     var promise = myservice.uploadtx(id,ob);


     promise.then(function(res){


    



       $scope.hideModel();
       $window.location.reload();



     },function(error){

        alert("上传失败");

     });


   }
 // Triggered on a button click, or some other target
 $scope.show = function() {

   // Show the action sheet
   var hideSheet = $ionicActionSheet.show({
     titleText: '上传头像',
     buttons: [
       { text: '相机' },
       { text: '相册' }
     ],
     
     destructiveText: '删除',
     cancelText: '取消',
     cancel: function() {
          // add cancel code..
        },
     buttonClicked:function(index) {
      switch (index){
                 case 0:
                    takePhoto();
                     break;
                 case 1:
                     pickImage();
                     break;

                 default:
                     break;
             }
       return true;
     },
     destructiveButtonClicked:function(){

     }
   });

   // For example's sake, hide the sheet after two seconds
   $timeout(function() {
     hideSheet();
   }, 2000);

 };
  var takePhoto = function () {
          var options = {
              //这些参数可能要配合着使用，比如选择了sourcetype是0，destinationtype要相应的设置
              quality: 100,                                            //相片质量0-100
              destinationType: Camera.DestinationType.FILE_URI,        //返回类型：DATA_URL= 0，返回作为 base64 編碼字串。 FILE_URI=1，返回影像档的 URI。NATIVE_URI=2，返回图像本机URI (例如，資產庫)
              sourceType: Camera.PictureSourceType.CAMERA,             //从哪里选择图片：PHOTOLIBRARY=0，相机拍照=1，SAVEDPHOTOALBUM=2。0和1其实都是本地图库
              allowEdit: false,                                        //在选择之前允许修改截图
              encodingType: Camera.EncodingType.JPEG,                   //保存的图片格式： JPEG = 0, PNG = 1
              targetWidth: 400,                                        //照片宽度
              targetHeight: 400,                                       //照片高度
              mediaType: 1,                                             //可选媒体类型：圖片=0，只允许选择图片將返回指定DestinationType的参数。 視頻格式=1，允许选择视频，最终返回 FILE_URI。ALLMEDIA= 2，允许所有媒体类型的选择。
              cameraDirection: 1,                                       //枪后摄像头类型：Back= 0,Front-facing = 1
              popoverOptions: CameraPopoverOptions,
              saveToPhotoAlbum: true                                   //保存进手机相册
          };
          $cordovaCamera.getPicture(options).then(function (imageData) {
            
            uploadImage("http://192.168.43.167:8080/kdpsxt/UploadFile",imageData);
            showModel();


          }, function (err) {
              // error
             // CommonJs.AlertPopup(err.message);
          });

      }

      var pickImage = function () {


     

       var options = {
           maximumImagesCount: 1,
           width: 800,
           height: 800,
           quality: 100
       };



 $cordovaImagePicker.getPictures(options)
           .then(function (results) {

             

                  var imageData = results[0];

                   uploadImage("http://192.168.43.167:8080/kdpsxt/UploadFile",imageData);

           }, function (error) {
               // error getting photos
           });
   }

      var uploadImage = function(serverurl,imagedata){

            document.addEventListener('deviceready', function (){

             $cordovaFileTransfer.upload(serverurl, imagedata, {})
                .then(function(result) {

                  var surl = result.response;

                  

                  

                  $scope.localimage=surl;

                  showModel();



                }, function(err) {

                  alert("error");
                  // Error
                }, function (progress) {
                  // constant progress updates
                });

            }, false);
        }
   $scope.tcdl = function() {

   // Show the action sheet
   var hideSheet = $ionicActionSheet.show({
     

     
     destructiveText: '退出登录',
    
    
     destructiveButtonClicked:function(){
          localStorage.clear();
          $window.location.reload();
     }
   });

   // For example's sake, hide the sheet after two seconds
   $timeout(function() {
     hideSheet();
   }, 2000);

 };
    if($scope.id!=null){
    $scope.shows=false;
    $scope.yhm=localStorage.getItem("yhm");
    var p=myservice.selecttx($scope.id);
    p.then(function(res){
      
       $scope.tx=res.data.tx;
    })
   
    }else{
    $scope.shows=true;
    }


})
.controller('CNTR1',function($scope,$state,myservice,$http,$ionicFilterBar){
    var filterBarInstance;
    var promise=myservice.SjData();
    promise.then(function(res){
        console.log(res.data);
        $scope.items=res.data;


    })
    
    $scope.showFilterBar = function () {
    filterBarInstance = $ionicFilterBar.show({
      items: $scope.items,
      update: function (filteredItems, filterText) {
        $scope.items = filteredItems;
        if (filterText) {
          console.log(filterText);
        }
      }
    });
  };

  $scope.doRefresh = function() {
    if (filterBarInstance) {
     filterBarInstance();
     filterBarInstance = null;
   }
    var promise = myservice.SjData();

  promise.then(function(res){

       $scope.items = res.data;

 $scope.$broadcast('scroll.refreshComplete');

  })
  };
    
})
.controller('CNTRSJXQ',function($scope,$stateParams,myservice,$cordovaSms,$state){
    var sjid=$stateParams.id;
    var yhid=localStorage.getItem("id");
    var yhxx="";
    var yhdz="";
    var yhdh="";
    var promise1=myservice.selecttx(yhid);
    promise1.then(function(res){
        yhxx=res.data.xx;
        yhdz=res.data.wddz;
        yhdh=res.data.wddh;
    })
    var promise=myservice.SjxqData(sjid);
    var phonenumber="";
    promise.then(function(res){
      $scope.sj=res.data.sj;
      phonenumber=res.data.sj.sjdh;
      $scope.items=res.data.sps;
      $scope.yhpjs=res.data.yhpj;
      
      for(var i=0;i<$scope.items.length;i++){
        
        $scope.items[i].num=0;
      }

    })

    $scope.zj=0;
    var zjg=0;
    $scope.updatenum=function(id,count){
      
          for(var i=0;i<$scope.items.length;i++){
            if(id==$scope.items[i].id){

                $scope.items[i].num=$scope.items[i].num+count;
                if($scope.items[i].num<0){
                  $scope.items[i].num=0;
                }
                if($scope.items[i].num>10){
                  $scope.items[i].num=10;
                }
                var spsl=$scope.items[i].num;
                var spjg=$scope.items[i].spjg;
                spjg=spjg*spsl;
                zjg=zjg+spjg;
                $scope.zj=zjg;
            }
            
          }
            
      }
      
    $scope.putclick=function(){
      if(localStorage.getItem('id')!=null){
      var spidsls="";
      var spmcsl="";
      
        for(var i=0;i<$scope.items.length;i++){
          
            if($scope.items[i].num!=0){
                var spid=$scope.items[i].id;
                spmcsl=spmcsl+$scope.items[i].spmc+'/'+$scope.items[i].num+';';
                var spsl=$scope.items[i].num;
               
                spidsls=spidsls+spid+":"+spsl+",";
            }
        }

        var jg=$scope.zj;
        if(jg!=0){
        var promise=myservice.addwmdd(yhid,sjid,jg,spidsls);
        promise.then(function(res){
          
          if(res.data){
            
        var concent="用户地址："+yhxx+yhdz+";"+"用户电话："+yhdh+";"+"商品/数量："+spmcsl;
        var options = {
        replaceLineBreaks: false, // true to replace \n by a new line, false by default
        android: {
            intent: ''  // send SMS with the native android SMS messaging
            //intent: '' // send SMS without open any other app
        }
    };
        $cordovaSms
        .send(phonenumber, concent,options)
        .then(function() {
            // Success! SMS was sent
            alert("下单成功");
        }, function(error) {
            // An error occurred
        });
         }
        })
      }else{
        alert("请选择商品");
      }
      }else{
        alert("请先登录在下单");
      }
    }
    $scope.pingjia={};
    
    $scope.yhsjpj=function(){
      if(localStorage.getItem('id')!=null){
      
      var promise2=myservice.addpj(yhid,sjid,$scope.pingjia.pj);
      promise2.then(function(res){
         if(res.data){
          alert("评价成功");
          $state.go('home.v2.sjxq',{},{reload:true});
         }else{
          alert("评价失败");
         }
      })
    }
    }
})
.controller('CNTR2',function($scope,$state,$stateParams,myservice,$ionicPopup, $timeout,$cordovaSms){
    if(localStorage.getItem('id')!=null){
    var jjrdz=$scope.jjrdz = $stateParams.jjrdz;
    var sjrdz=$scope.sjrdz = $stateParams.sjrdz;
    var wplx=$scope.wplx = $stateParams.wplx;
    var kdgs=$scope.kdgs = $stateParams.kdgs;
    var wpzl=$scope.wpzl = $stateParams.wpzl;
    var bz=$scope.bz = $stateParams.bz;
    var jjrcs=$scope.jjrcs=$stateParams.jjrcs;
    var jjrxm=$scope.jjrxm=$stateParams.jjrxm;
    var sjrxm=$scope.sjrxm=$stateParams.sjrxm;
    var sjrcs=$scope.sjrcs=$stateParams.sjrcs;
    var sjrdh=$scope.sjrdh=$stateParams.sjrdh;
    var jjrdh=$scope.jjrdh=$stateParams.jjrdh;
    var id=localStorage.getItem('id');
    var jjr=jjrcs.split('-')[0];
    var sjr=sjrcs.split('-')[0];
    var shyid;
    var yhid=localStorage.getItem('id');
    var jg;
        var promise1=myservice.JlData(jjrdz,sjrdz,jjr,sjr);
    promise1.success(function(res){
      if(res.status==0){
         var jl=res.result.routes[0].distance;
         console.log(jl);
          if(jl<=1500000){
            jg=$scope.jg=6*(parseInt(wpzl/500)+1);
            
             var promise=myservice.glshy(yhid);//DdData($scope.ddid,jjrdz,sjrdz,wplx,wpzl,kdgs,id,jg,jjrcs,sjrcs,jjrxm,sjrxm,sjrdh,jjrdh);
                promise.then(function(res){
                  console.log(res.data);
                  shyid=res.data.id;
                    $scope.shydh=res.data.dh;
                  $scope.shyxm=res.data.xm;
                  
                });

          }
          if(jl<2500000&&jl>1500000){
            jg=$scope.jg=9*(parseInt(wpzl/500)+1);
            
             var promise=myservice.glshy(yhid);
                promise.then(function(res){
                  
                  shyid=res.data.id;
                  $scope.shydh=res.data.dh;
                  $scope.shyxm=res.data.xm;
                  
                });

                
          }
          if(jl>=2500000){
            jg=$scope.jg=15*(parseInt(wpzl/500)+1);
           
             var promise=myservice.glshy(yhid);
                promise.then(function(res){
                    $scope.shydh=res.data.dh;
                  shyid=res.data.id;
                  
                  $scope.shyxm=res.data.xm;
                  
                });
          }
      }else{
        alert("输入有误");
      }

    });
    $scope.tijiao=function(){
    if($scope.shyxm!=''){
            var promise=myservice.addksdd(jjrdz,sjrdz,yhid,shyid,wplx,bz,wpzl,$scope.jg,kdgs);
            promise.then(function(res){
              $scope.ddid=res.data;
            })
            //快递公司编码   订单编号  付款方式（4）  快递类型（1）  收件人  收件人手机号   收件人省、市、地址  发件人同  商品名称
          var promise1=myservice.DdData($scope.ddid,jjrdz,sjrdz,wplx,wpzl,kdgs,id,jg,jjrcs,sjrcs,jjrxm,sjrxm,sjrdh,jjrdh);
          promise1.then(function(res){
            console.log(res.data);
            //alert("预计到达时间："+res.data.PrintTemplate);
              var ddh=res.data.Order.LogisticCode;
                var promise2=myservice.updateksdd($scope.ddid,ddh);
                promise2.then(function(res){
                    if(res.data){
                   

                  // An elaborate, custom popup
                  // var myPopup = $ionicPopup.show({
                  //   template: res.data.PrintTemplate,
                  //   title: '电子面单',
                  //   subTitle: '',
                  //   scope: $scope,
                  //   buttons: [
                  //     { text: '关闭' },
                  //   ]
                  // });

                  // myPopup.then(function(res) {
                  //   console.log('Tapped!', res);
                  // });

                  // $timeout(function() {
                  //    myPopup.close(); //close the popup after 3 seconds for some reason
                  // }, 6000);
                      alert("以生成电子面单");
                      var phonenumber=$scope.shydh;
                     var concent="寄件人地址地址："+jjrcs+jjrdz+";"+"寄件人电话："+jjrdh+";"+"寄件人姓名："+jjrxm+"收件人地址："+sjrcs+sjrdz+";"+"收件人电话："+sjrdh+";"+"收件人姓名："+sjrxm;
                        var options = {
                        replaceLineBreaks: false, // true to replace \n by a new line, false by default
                        android: {
                            intent: ''  // send SMS with the native android SMS messaging
                            //intent: '' // send SMS without open any other app
                        }
                    };
                        $cordovaSms
                        .send(phonenumber, concent,options)
                        .then(function() {
                            // Success! SMS was sent
                            alert("已通知收货员");
                        }, function(error) {
                           alert("通知收货员失败");
                        });

                    }else{
                      alert("提交失败");
                    }


                })




                 
          })
        }
          
        }
    
   }else{
    alert("请登录");
   }
})
.controller('ZCCNTR',function($scope,myservice){
    
    $scope.zc=function(yhm,mm,sjh,xx,dz){
    
    var promise=myservice.ZcData(yhm,mm,sjh,xx,dz);
    promise.then(function(res){
        if(res){
          alert("注册成功");
        }else{
          alert("注册失败");
        }
    })
    }

})
.controller('DLCNTR',function($scope,myservice,$state){
    $scope.dl=function(yhm,mm){
        var promise=myservice.dl(yhm,mm);
        promise.then(function(res){
            if(res.data.id==null){
              alert("登录失败");
            }else{
               
              var id=res.data.id;
            localStorage.setItem("id",id);
            var yhm=res.data.yhm;
            localStorage.setItem("yhm",yhm);
           
             $state.go('home.v3',{},{reload:true});
            }
        })

    }



})
.controller('CITYCNTR',function($scope){
    $scope.CityPickData1 = {      
  cssClass:'ionic-citypicker list',//显示地区选择的样色类，默认'ionic-citypicker list'       
  iconPosition:'',//图标显示位置       
  iconClass:'',// 图标类，默认'ion-android-pin'
  title:'寄件人地址',//显示的主题，默认'地址'
  closeText:'取消',//取消按钮显示的文本,默认'取消',可以是ionic图标
  buttonText:'确定',//确定按钮的文本，默认'确定',可以是ionic图标
  backdrop:true,//是否显示背景幕，默认是true
  isCache:true,//该UI-router状态所对应的template是否是有缓存的，如果在状态中设置了cache:false,代表是没有缓存，那么必须设置该值iscache:false,如果路由状态中设置了cache:true或者没有设置（默认true),那么这个isCache可以不设置，利用默认的true就可以了。
  id:1
};
  
  $scope.CityPickData2 = {      
  cssClass:'ionic-citypicker list',//显示地区选择的样色类，默认'ionic-citypicker list'       
  iconPosition:'',//图标显示位置       
  iconClass:'',// 图标类，默认'ion-android-pin'
  title:'收件人地址',//显示的主题，默认'地址'
  closeText:'取消',//取消按钮显示的文本,默认'取消',可以是ionic图标
  buttonText:'确定',//确定按钮的文本，默认'确定',可以是ionic图标
  backdrop:true,//是否显示背景幕，默认是true
  isCache:true,//该UI-router状态所对应的template是否是有缓存的，如果在状态中设置了cache:false,代表是没有缓存，那么必须设置该值iscache:false,如果路由状态中设置了cache:true或者没有设置（默认true),那么这个isCache可以不设置，利用默认的true就可以了。
  id:2
};
  
   $scope.address1=$(".address1").html();
   $scope.address2=$(".address2").html();





})
.controller('CNTR3',function($scope,myservice){
  var id=localStorage.getItem('id');
  var promise=myservice.kdcx(id);
  promise.then(function(res){
    console.log(res.data[0].Reason);
    var str=[];
    for(var i=0;i<res.data.length;i++){
      
      if(res.data[i].Reason==""){
        $scope.items=res.data[i].Traces;
        console.log($scope.items);
      }
    }
  })
})
.controller('GRSZCNTR',function($scope,myservice){
    var id=localStorage.getItem('id');
    var promise1=myservice.selecttx(id);
    promise1.then(function(res){
      $scope.yhm=res.data.yhm;
      $scope.sjh=res.data.wddh;
      $scope.xx=res.data.xx;
      $scope.dz=res.data.wddz;
    });
      $scope.tijiao=function(){
      var yhm=$scope.yhm;
      var sjh=$scope.sjh;
      var xx=$scope.xx;
      var dz=$scope.dz;
      var promise=myservice.grsz(id,yhm,sjh,xx,dz);
      promise.then(function(res){
        if(res.data){
            localStorage.removeItem("yhm");
            localStorage.setItem("yhm",yhm);
           alert("修改成功");
             $state.go('home.v3',{},{reload:true});
        }else{
          alert("修改失败");
        }
      })
    }
})
.controller('CNTRWMDD',function($scope,myservice,$state){
    var id=localStorage.getItem('id');
    var promise1=myservice.selectwmdd(id);
    promise1.then(function(res){
      console.log(res.data);
      $scope.items=res.data;
    });

    
})