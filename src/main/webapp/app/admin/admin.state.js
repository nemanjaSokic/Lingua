(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/admin", {
                    templateUrl : 'app/admin/admin.html',
                    controller : 'AdminController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck,
                        getStudents: getStudents
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

        function accountService(StudentService){
            return StudentService.getOne()
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
        function loginCheck(LoginService, $location){
            return LoginService.check()
                .then(function(result){
                    console.log(result);
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