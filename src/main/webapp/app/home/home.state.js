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
                        "check":function(LoginService, $rootScope){
                            LoginService.check()
                                .then(function(result){
                                    var result = result.data;
                                    if(result !== ''){
                                        $rootScope.account = result.name;
                                        $rootScope.role = result.authorities[0].authority;
                                        $rootScope.authenticated = result.authenticated;
                                    }else{
                                       $rootScope.authenticated = result.authenticated;
                                    }
                                },function(error){
                                    $rootScope.authenticated = false;
                                    console.log(error.statusText);
                                });
                        }
                    }
                })
        }
})();
