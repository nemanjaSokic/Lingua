(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminStudentController', AdminStudentController);

    AdminStudentController.$inject = ['$rootScope', '$scope', 'accountService', 'loginCheck', 'StudentService', '$location'];

    function AdminStudentController ($rootScope, $scope, accountService, loginCheck, StudentService, $location) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.student = accountService;
        vm.student.registrovan_temp = vm.student.registrovan;
        vm.error = {
            message: 'default message',
            show: false
        }
        vm.confirmChanges= function () {
            vm.student.registrovan = vm.student.registrovan_temp;
            return StudentService.edit(vm.student).then(function(result){
                $location.path("/admin");
            }, function(error){
                vm.error.message = 'There is some problem';
                vm.error.show = true;
            });
        }
        vm.delete = function(){
            return StudentService.delete(vm.student.indeks).then(function(result){
                $location.path("/admin");
            },function(error){
                vm.error.message = 'There is some problem';
                vm.error.show = true;
            })
        }
    }
})();
