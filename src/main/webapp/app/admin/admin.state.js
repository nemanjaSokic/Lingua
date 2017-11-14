(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/admin", {
                    templateUrl : 'app/admin/admin.html',
                    controller : 'AdminController',
                    controllerAs: 'vm',
                    resolve: {
                        "check":function(LoginService, $rootScope, $location){
                            LoginService.check()
                                .then(function(result){
                                    var result = result.data;
                                    if(result !== '' && result.name === 'admin'){
                                        $rootScope.account = result.name;
                                        $rootScope.role = result.authorities[0].authority;
                                        $rootScope.authenticated = result.authenticated;
                                    }else{
                                        $location.path('/');
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
