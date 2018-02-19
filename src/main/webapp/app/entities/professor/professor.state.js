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
                })
                .when("/professor/:username/courses/:courseId",{
                    templateUrl: 'app/entities/professor/course/course.html',
                    controller: 'ProfessorCourseDialogController',
                    controllerAs: 'vm',
                    resolve: {
                        courses: courses
                    }
                })
                .when("/professor/:username/students",{
                    templateUrl: 'app/entities/professor/student/professor-student.html',
                    controller: 'ProfessorStudentController',
                    controllerAs: 'vm',
                    resolve: {
                        students: allStudents
                    }
                });
        }
        function allStudents($route,StudentService){
            return StudentService.getAllByProfessor($route.current.params.username).then(function(result){
                console.log(result);
                return result.data;
            })
        }
        function courses($route,CourseService){
            return CourseService.getAllCoursesByProfessorUsername($route.current.params.username).then(function(res){
                return res.data;
            });
        }
})();
