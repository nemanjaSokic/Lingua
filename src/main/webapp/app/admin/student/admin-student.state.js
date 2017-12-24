(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/admin/student/dashbord", {
                    templateUrl : 'app/admin/student/student-dashbord.html',
                    controller : 'AdminStudentController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck,
                        accountService: getStudents
                    }
                })
                .when("/admin/student/:index", {
                    templateUrl : 'app/admin/student/admin-student.html',
                    controller : 'AdminStudentController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck,
                        accountService: accountService
                    }
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

        function accountService(StudentService, $route){
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