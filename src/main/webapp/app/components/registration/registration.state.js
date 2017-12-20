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
                        courseTypePrepService: courseTypePrepService,
                        langPrepService: langPrepService
                    }
                })
                .when("/signup/success", {
                    templateUrl : 'app/components/registration/success.html'
                });
        }
        function courseTypePrepService(RegistrationService){
            return RegistrationService.getAllCourseTypes().then(function(res){
                return res.data;
            });
        };
        function langPrepService(LanguageService){
            return LanguageService.getAll().then(function(response){
                return response.data;
            });
        };
})();
