var m = angular.module('MyService',[]);

 m.service('myservice',function($http){
//192.168.43.167
//localhost:8080
  this.zcurl = "http://192.168.43.167:8080/kdpsxt/zc";
  this.dlurl="http://192.168.43.167:8080/kdpsxt/dl";
  this.ddurl="http://192.168.43.167:8080/kdpsxt/dd";
  this.jlurl="http://api.map.baidu.com/direction/v1";
  this.sjurl="http://192.168.43.167:8080/kdpsxt/sj";
  this.sjxqurl="http://192.168.43.167:8080/kdpsxt/sjxq";
  this.uploadtxurl="http://192.168.43.167:8080/kdpsxt/uploadtx";
  this.selecttxurl="http://192.168.43.167:8080/kdpsxt/selecttx";
  this.wmddurl="http://192.168.43.167:8080/kdpsxt/addwmdd";
  this.addpjurl="http://192.168.43.167:8080/kdpsxt/addpj";
  this.addksddurl="http://192.168.43.167:8080/kdpsxt/addksdd";
  this.glshyurl="http://192.168.43.167:8080/kdpsxt/glshy";
  this.updateksddurl="http://192.168.43.167:8080/kdpsxt/updateksdd";
  this.kdcxurl="http://192.168.43.167:8080/kdpsxt/hyfw";
  this.grszurl="http://192.168.43.167:8080/kdpsxt/grsz";
  this.selectwmddurl="http://192.168.43.167:8080/kdpsxt/selectwmdd";
  this.selectwmdd=function(id){
    var promise=$http({
      url:this.selectwmddurl,
      method:'POST',
      params:{
        yhid:id
      }
    })
    return promise;
  }
  this.grsz=function(id,yhm,sjh,xx,dz){
    var promise=$http({
      url:this.grszurl,
      method:'POST',
      params:{
        id:id,
        yhm:yhm,
        sjh:sjh,
        xx:xx,
        dz:dz
      }
    })
    return promise;
  }
  this.kdcx = function(id,yhm,sjh,xx,dz){

     var promise = $http({

          url:this.kdcxurl,
          method:'POST',
          params:{
           id:id,
           yhm:yhm,
           sjh:sjh,
           xx:xx,
           dz:dz
          }
     })

     return promise;




  }

  this.updateksdd = function(id,ddh){

     var promise = $http({

          url:this.updateksddurl,
          method:'POST',
          params:{
            id:id,
            ddh:ddh
          }
     })

     return promise;




  }

  this.glshy = function(id){

     var promise = $http({

          url:this.glshyurl,
          method:'POST',
          params:{
            id:id
          }
     })

     return promise;




  }

  this.addksdd = function(fhdz,shdz,yhid,shyid,zl,xq,wpzl,jg,kdgs){

     var promise = $http({

          url:this.addksddurl,
          method:'POST',
          params:{
            fhdz:fhdz,
            shdz:shdz,
            yhid:yhid,
            shyid:shyid,
            zl:zl,
            xq:xq,
            wpzl:wpzl,
            jg:jg,
            kdgs:kdgs
          }
     })

     return promise;




  }

   this.addpj = function(yhid,sjid,pj){

     var promise = $http({

          url:this.addpjurl,

          method:'POST',
          params:{
            yhid:yhid,
            sjid:sjid,
            pj:pj
          }
          



     })

     return promise;




  }

 this.addwmdd = function(yhid,sjid,jg,spidsls){

     var promise = $http({

          url:this.wmddurl,

          method:'POST',
          params:{
            yhid:yhid,
            sjid:sjid,
            jg:jg,
            spidsls:spidsls
          }
          



     })

     return promise;




  }

  this.selecttx = function(id){

     var promise = $http({

          url:this.selecttxurl,

          method:'POST',
          params:{
            id:id
          }
          



     })

     return promise;




  }

  this.SjxqData = function(id){

     var promise = $http({

          url:this.sjxqurl,

          method:'POST',
          params:{
            id:id
          }
          



     })

     return promise;




  }


  this.SjData = function(){

     var promise = $http({

          url:this.sjurl,

          method:'POST',

          



     })

     return promise;




  }

  this.JlData = function(jjrdz,sjrdz,jjrcs,sjrcs){

     var promise = $http({

          url:this.jlurl,

          method:'jsonp',
          headers:{
          'Content-Type': 'application/x-www-form-urlencoded'
          },
          params:{

            mode:'driving',

            origin:jjrdz,

            destination:sjrdz,

            origin_region:jjrcs,
            destination_region:sjrcs,
            output:'json',
            callback:'JSON_CALLBACK',
            ak:'zfgsdET9act8ihfwCv7V6CUzNCq6Dh02'
          }



     })

     return promise;




  }

  this.DdData = function(ddid,jjrdz,sjrdz,wplx,wpzl,kdgs,id,jg,jjrcs,sjrcs,jjrxm,sjrxm,sjrdh,jjrdh){

     var promise = $http({

          url:this.ddurl,

          method:'POST',

          params:{
            ddid:ddid,
            jjrdz:jjrdz,

            sjrdz:sjrdz,

            wplx:wplx,

            wpzl:wpzl,

            kdgs:kdgs,

            id:id,
            jg:jg,
            jjrcs:jjrcs,
            sjrcs:sjrcs,
            jjrxm:jjrxm,
            sjrxm:sjrxm,
            sjrdh:sjrdh,
            jjrdh:jjrdh
          }



     })

     return promise;




  }
  this.ZcData = function(yhm,mm,sjh,xx,dz){

     var promise = $http({

          url:this.zcurl,

          method:'POST',

          params:{

            yhm:yhm,

            mm:mm,

            sjh:sjh,

            wdxx:xx,

            wddz:dz


          }



     })

     return promise;




  }



  this.dl=function(yhm,mm){
    var promise=$http({
      url:this.dlurl,

          method:'POST',

          params:{

            yhm:yhm,

            mm:mm
          }



    })

    return promise;

  }

  this.uploadtx=function(id,imgdata){
    var promise=$http({
      url:this.uploadtxurl,

          method:'POST',

          params:{

            
            id:id,

            imgdata:imgdata
          }



    })

    return promise;


  }

})