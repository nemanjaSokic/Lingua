(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/student/dashboard", {
                    templateUrl : 'app/entities/student/dashboard.html',
                    controller : 'StudentController',
                    controllerAs: 'vm'
                })
        }
})();
