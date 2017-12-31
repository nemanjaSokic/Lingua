(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminProfessorController', AdminProfessorController);

    AdminProfessorController.$inject = ['$rootScope', '$scope', '$uibModal', 'profService', 'loginCheck', 'ProfessorService', '$log', '$location'];

    function AdminProfessorController ($rootScope, $scope, $uibModal, profService, loginCheck, ProfessorService, $log, $location) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.prof = profService;

        vm.prof.registrovan_temp = vm.prof.registrovan;
        
        vm.error = {
            message: 'default message',
            show: false
        }
        vm.confirmChanges= function () {
            vm.prof.registrovan = vm.prof.registrovan_temp;
            return ProfessorService.edit(vm.prof).then(function(result){
                $location.path("/admin/professor/dashboard");
            }, function(error){
                vm.error.message = 'There is some problem';
                vm.error.show = true;
            });
        }
        vm.delete = function(){
            return ProfessorService.delete(vm.prof.id).then(function(result){
                $location.path("/admin/professor/dashboard");
            },function(error){
                vm.error.message = 'There is some problem';
                vm.error.show = true;
            })
        }
        
    }
})();
