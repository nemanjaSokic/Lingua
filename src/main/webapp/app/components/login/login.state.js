(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/login", {
                    templateUrl : 'app/components/login/login.html',
                    controller : 'LoginController',
                    controllerAs: 'vm'
                })
        }
})();
