(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminInfoStudentController', AdminInfoStudentController);

    AdminInfoStudentController.$inject = ['$scope','loginCheck','studentService','marks','payments','LoginService'];
    function AdminInfoStudentController($scope,loginCheck,studentService,marks,payments,LoginService) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.student = studentService;
        vm.marks = marks;
        vm.payments = payments;
        
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