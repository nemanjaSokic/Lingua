(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/signup", {
                    templateUrl : 'app/components/registration/registration.html',
                    controller : 'RegistrationController',
                    controllerAs: 'vm',
                    resolve: {
                        coursePrepService: coursePrepService
                    }
                })
                .when("/signup/success", {
                    templateUrl : 'app/components/registration/success.html'
                });
        }
        function coursePrepService(RegistrationService){
            return RegistrationService.getAllCourse().then(function(res){
                return res.data;
            });
        }
})();
