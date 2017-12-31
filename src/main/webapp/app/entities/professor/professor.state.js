(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/professor/dashboard", {
                    templateUrl : 'app/entities/professor/dashboard.html',
                    controller : 'ProfessorController',
                    controllerAs: 'vm'
                })
        }
})();
