(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminStudentController', AdminStudentController);

    AdminStudentController.$inject = ['$rootScope', '$scope', 'studentService', 'loginCheck', 'StudentService', '$log', '$location','LoginService'];

    function AdminStudentController ($rootScope, $scope, studentService, loginCheck, StudentService, $log, $location,LoginService) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.student = studentService;
        
        
        $scope.logout = function() {
            LoginService.logOut()
                .then(function(result){
                    $location.path("/login");
                },function(error){
                    vm.isAuth = false;
                    console.log(error.statusText);
                });
        }
    }
})();
