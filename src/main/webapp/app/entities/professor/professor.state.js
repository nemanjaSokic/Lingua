(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/professor/dashbord", {
                    templateUrl : 'app/entities/professor/dashbord.html',
                    controller : 'ProfessorController',
                    controllerAs: 'vm'
                })
        }
})();
