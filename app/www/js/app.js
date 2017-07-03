// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic','Mycontroller','tabSlideBox','bing.ionic.pickcity','ionic-pickcity.service'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
      cordova.plugins.Keyboard.disableScroll(true);

    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleDefault();
    }
  });
}).directive('hideTabs', function($rootScope) {
    return {
        restrict: 'A',
        link: function(scope, element, attributes) {
            scope.$on('$ionicView.beforeEnter', function() {
                scope.$watch(attributes.hideTabs, function(value){
                    $rootScope.hideTabs = value;
                });
            });

            scope.$on('$ionicView.beforeLeave', function() {
                $rootScope.hideTabs = false;
            });
        }
    };
})

.config(function($stateProvider, $urlRouterProvider,$ionicConfigProvider) {
  $ionicConfigProvider.platform.ios.tabs.style('standard');
        $ionicConfigProvider.platform.ios.tabs.position('bottom');
        $ionicConfigProvider.platform.android.tabs.style('standard');
        $ionicConfigProvider.platform.android.tabs.position('standard');

        $ionicConfigProvider.platform.ios.navBar.alignTitle('center');
        $ionicConfigProvider.platform.android.navBar.alignTitle('bottom');//默认为left

        $ionicConfigProvider.platform.ios.backButton.previousTitleText('').icon('ion-ios-arrow-thin-left');
        $ionicConfigProvider.platform.android.backButton.previousTitleText('').icon('ion-android-arrow-back');

        $ionicConfigProvider.platform.ios.views.transition('ios');
        $ionicConfigProvider.platform.android.views.transition('android');

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider.state('home',{
    url:'/home',
    views:{
      'm1@':{
        templateUrl:'templates/tabs.html'
      }
    }
  }).state('home.v1',{
    url:'/v1',
    views:{
      'v1@home':{
        templateUrl:'templates/v1.html'
      }
    }
  }).state('home.v1.sy1',{
    url:'/sy1',
    views:{
      'sy1@home.v1':{
        
        controller:'CITYCNTR',
        templateUrl:'templates/sy1.html'

      }
    }
  }).state('home.v1.sy2',{
    url:'/sy2',
    views:{
      'sy2@home.v1':{
        controller:'CNTR3',
        templateUrl:'templates/sy2.html'
      }
    }
  }).state('home.v2',{
    url:'/v2',
    views:{
      'v2@home':{
        controller:'CNTR1',
        templateUrl:'templates/v2.html'
      }
    }
  }).state('home.v3',{
    url:'/v3',
    views:{
      'v3@home':{
        controller:'CNTR',
        reload:'true',
        templateUrl:'templates/v3.html'
      }
    }
  }).state('home.v3.zc',{
    url:'/zc',
    views:{
      'v3@home':{
        templateUrl:'templates/zc.html',
        controller:'ZCCNTR'
      }
    }
  }).state('home.v3.dl',{
    url:'/dl',
    views:{
      'v3@home':{
        templateUrl:'templates/dl.html',
        controller:'DLCNTR'
      }
    }
  }).state('home.v3.grsz',{
    url:'/grsz',
    views:{
      'v3@home':{
        controller:'GRSZCNTR',
        templateUrl:'templates/grsz.html'
      }
    }
  }).state('home.v1.zrxq',{
    url:'/zrxq/{jjrdz}/{sjrdz}/{wplx}/{kdgs}/{wpzl}/{bz}/{jjrcs}/{sjrcs}/{jjrxm}/{sjrxm}/{jjrdh}/{sjrdh}',
    views:{
      'sy1@home.v1':{
        controller:'CNTR2',
        templateUrl:'templates/zrxq.html'
      }
    }
  }).state('home.v2.sjxq',{
    url:'/sjxq/{id}',
    views:{
      'v2@home':{
        controller:'CNTRSJXQ',
        templateUrl:'templates/spxq.html'
      }

    }

  }).state('home.v3.wmdd',{
    url:'/wmdd',
    views:{
      'v3@home':{
        controller:'CNTRWMDD',
        templateUrl:'templates/wmdd.html'
      }

    }

  })

  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/home/v1');

});
