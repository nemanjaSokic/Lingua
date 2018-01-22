(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/professor/:username/home", {
                    templateUrl : 'app/entities/professor/professor-home.html',
                    controller : 'ProfessorController',
                    controllerAs: 'vm',
                    resolve:{
                    }
                })
                .when("/professor/:username/courses",{
                    templateUrl: 'app/entities/professor/course/professor-course.html',
                    controller: 'ProfessorCourseController',
                    controllerAs: 'vm',
                    resolve: {
                        courses: courses
                    }
                });
        }
        function courses($route,CourseService){
            return CourseService.getAllCoursesByProfessorUsername($route.current.params.username).then(function(res){
                return res.data;
            });
        }
})();
