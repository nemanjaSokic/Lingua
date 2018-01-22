(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/student/:username/home", {
                    templateUrl : 'app/entities/student/student-home.html',
                    controller : 'StudentController',
                    controllerAs: 'vm'
                })
        }
})();
