(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/admin/student/dashboard", {
                    templateUrl : 'app/admin/student/student-dashboard.html',
                    controller : 'AdminStudentController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck,
                        studentService: getStudents
                    }
                })
                .when("/admin/student/:index", {
                    templateUrl : 'app/admin/student/admin-student.html',
                    controller : 'AdminInfoStudentController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck,
                        studentService: getAccount,
                        marks: getMarks,
                        payments: getPayments
                    }
                });
        }
        function getMarks(StudentService,$route){
            return StudentService.getMarks($route.current.params.index)
                .then(function(res){
                    return res.data;
                });
        }
        function getPayments(StudentService,$route){
            return StudentService.getPayments($route.current.params.index)
                .then(function(res){
                    return res.data;
                });
        }
        function getStudents(StudentService){
            return StudentService.getAll().
                then(function(result){
                    return result.data;
                },function(error){
                    return {error: true,
                            errorMessage: error.data.message
                            }
                });
        }

        function getAccount(StudentService, $route){
            return StudentService.getOne($route.current.params.index).
                then(function(res){
                    return res.data;
                },function(error){
                    return {
                        error: true,
                        errorMessage: error.data.message
                    }
                });
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