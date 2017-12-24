(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/student/dashbord", {
                    templateUrl : 'app/entities/student/dashbord.html',
                    controller : 'StudentController',
                    controllerAs: 'vm'
                })
        }
})();
