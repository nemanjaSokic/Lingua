(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig)
        .run(function($rootScope, LoginService, $location, validateCookie, $route) {
            $rootScope.$on('$routeChangeSuccess', function () {
                validateCookie();
            });
            $rootScope.logout = function() {
                LoginService.logOut()
                    .then(function(result) {
                        $location.path("/");
                        $route.reload();
                    }, function(error) {
                        $rootScope.authenticated = false;
                        console.log(error.statusText);
                    });
            };
        })
        .factory('validateCookie', function($rootScope,LoginService,$location){
            return function(){
                return LoginService.check()
                    .then(function(result){
                        var res = result.data;
                        console.log(res);
                        $rootScope.isAuth = res.authenticated;
                        if(res !== ''){
                            return res;
                        }else{
                            $location.path('/');
                        }
                    },function(error){
                        console.log(error.statusText);
                    }
                );
            }
        });
        

    stateConfig.$inject = ['$routeProvider', '$locationProvider', '$httpProvider'];

    function stateConfig($routeProvider, $locationProvider, $httpProvider) {
        $locationProvider.hashPrefix('');
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
        $routeProvider
            .otherwise({
                redirectTo: '/'
            });
    }
})();
