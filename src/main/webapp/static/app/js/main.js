var linguaApp = angular.module('linguaApp', ['ngRoute']);


linguaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/static/app/html/partial/home.html'
        })
        .when('/languages', {
            templateUrl : '/static/app/html/partial/language.html',
            controller : 'CourseController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);