(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/", {
                    templateUrl : 'app/home/home.html',
                    controller : 'HomeController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck
                    }
                });
        }
        function loginCheck(LoginService, $rootScope){
            return LoginService.check()
                .then(function(result){
                    var res = result.data;
                    if(res !== ''){
                        return res;
                    }else{
                        return {name: 'anonymus',
                                authenticated: false
                                };
                    }
                },function(error){
                    console.log(error.statusText);
                }
            );
        }
})();
