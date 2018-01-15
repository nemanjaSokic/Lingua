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
                    resolve: {}
                });
        }
})();
