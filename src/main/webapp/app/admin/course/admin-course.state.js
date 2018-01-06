(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/admin/course/dashboard", {
                    templateUrl : 'app/admin/course/course-dashboard.html',
                    controller : 'AdminCourseController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck,
                        courseServ: getAllCourse
                    }
                })
                .when("/admin/course/:id", {
                    templateUrl : 'app/admin/course/admin-course.html',
                    controller : 'AdmiInfoCourseController',
                    controllerAs: 'vm',
                    resolve: {
                         loginCheck: loginCheck,
                        courseServ: getCourse,
                        courseStudent: courseStudent,
                        courseTest: courseTest 
                    }
                });
        }
        function courseStudent(CourseService,$route){
            return CourseService.getCourseStudent($route.current.params.id)
                .then(function(res){
                    return res.data;
                })
        }
        function courseTest(CourseService,$route){
            return CourseService.getCourseTests($route.current.params.id)
                .then(function(res){
                    return res.data;
                })
        }
        function getCourse(CourseService,$route){
            return CourseService.getOne($route.current.params.id)
                .then(function(res){
                    return res.data;
                })
        }
        function getAllCourse(CourseService){
            return CourseService.getAllCourse()
                .then(function(res){
                    return res.data;
                })
        }
        function loginCheck(LoginService, $location){
            return LoginService.check()
                .then(function(result){
                    var res = result.data;
                    if(res !== '' && res.authenticated == true && res.name === 'admin'){
                        return res;
                    }else{
                        $location.path("/login");
                    }
                },function(error){
                    console.log(error.statusText);
                }
            );
        }
})();