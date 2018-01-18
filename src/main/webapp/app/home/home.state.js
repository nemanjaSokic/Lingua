(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

    stateConfig.$inject = ['$routeProvider'];

    function stateConfig($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl: 'app/home/home.html',
                controller: 'HomeController',
                controllerAs: 'vm',
                resolve: {
                    bodyClass: function() {
                        return "homeDiv";
                    }
                }
            })
            .when("/aboutus", {
                templateUrl: 'app/home/aboutUs.html',
                controller: 'HomeController',
                controllerAs: 'vm',
                resolve: {
                    bodyClass: function() {
                        return "aboutUsDiv";
                    }
                }
            })
            .when("/aboutT", {
                templateUrl: 'app/home/aboutTeachers.html',
                controller: 'HomeController',
                controllerAs: 'vm',
                resolve: {
                    bodyClass: function() {
                        return "aboutTDiv";
                    }
                }
            });
    }
})();