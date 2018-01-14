(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminInfoProfessorController', AdminInfoProfessorController);

    AdminInfoProfessorController.$inject = ['$rootScope', '$scope', '$uibModal', 'courses', 'profService', 'loginCheck', 'languages', 'ProfessorService', '$log', '$location','LoginService','UserService'];
    function AdminInfoProfessorController($rootScope, $scope, $uibModal, courses, profService, loginCheck,languages,ProfessorService, $log, $location,LoginService,UserService) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.prof = profService;
        
        vm.prof.courses = courses;
        vm.languages = languages;
        vm.prof.registrovan_temp = vm.prof.registrovan;
        vm.error = {
            message: 'default message',
            show: false
        }
        vm.email = {};
        $scope.showLanguages = false;
        vm.sendEmail = function(){
            vm.email.to = vm.prof.email;
            return UserService.sendEmail(vm.email).then(function(result){
                vm.email = {};
            }); 
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