(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig)
        .run(function($rootScope, LoginService, $location, validateUser, $route) {
            $rootScope.$on('$routeChangeSuccess', function () {
                var routesOpenToPublic = [];
                angular.forEach($route.routes, function(route, path) {
                    // push route onto routesOpenToPublic if it has a truthy publicAccess value
                    route.publicAccess && (routesOpenToPublic.push(path));
                });
                validateUser().then(function(result){
                    var closedToPublic = (-1 === routesOpenToPublic.indexOf($location.path()));
                    if(closedToPublic && !$rootScope.user.isAuth) {
                        $location.path('/login');
                    }else if(closedToPublic && !($location.path().startsWith('/'+$rootScope.user.role.toLowerCase()))){
                        $location.path('/');
                    }
                });
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
        .factory('validateUser', function($rootScope,LoginService){
            return function(){
                $rootScope.user = {};
                return LoginService.check()
                    .then(function(result){
                        var res = result.data;
                        if(res !== ''){
                            $rootScope.user.isAuth = res.authenticated;
                            $rootScope.user.name = res.name;
                            $rootScope.user.role = res.authorities[0].authority;
                            return res;
                        }else{
                            $rootScope.user.isAuth = res.authenticated;
                            $rootScope.user.name = 'anonymus';
                            $rootScope.user.role = 'guest';
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
