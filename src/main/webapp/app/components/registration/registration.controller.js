(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('RegistrationController', RegistrationController);

    RegistrationController.$inject = ['$rootScope', '$scope', 'coursePrepService' ,'RegistrationService', '$location'];

    function RegistrationController ($rootScope, $scope, coursePrepService, RegistrationService, $location) {
        var vm = this;
        vm.userInfo = {
            user:{},
            person:{}
        };
        vm.userInfo.user.telefonKorisnika = 381;
        vm.courses = coursePrepService;

        $scope.emailTrim = function(u){
            if(vm.userInfo.user.email && vm.userInfo.user.email.indexOf("@") != -1){
                vm.userInfo.user.korisnickoIme = u.substring(0,vm.userInfo.user.email.indexOf("@"));
                $scope.checkUser();
            }
        }
        $scope.checkPass = function(){
            if($scope.confPass === vm.userInfo.user.sifraKorisnika && vm.userInfo.user.sifraKorisnika){
                $scope.confirmMessage = "Good type!";
                return true;
            }else{
                return false;
            }
        }
        $scope.checkUser = function(){
            RegistrationService.isUsernameExisted(vm.userInfo.user.korisnickoIme).then(function(res){
                var result = res.data;
                $scope.userError = result;
                return result;
            });
        }
        $scope.register = function(){
            vm.userInfo.user.registrovan = false;
            var course = JSON.parse(vm.course);
            if(vm.userInfo.user.tipKorisnika === 'NASTAVNIK'){
                vm.userInfo.person.predaje = course.nastavnik.predaje;
                vm.professor = vm.userInfo.person;
                vm.student = {};
            }else if(vm.userInfo.user.tipKorisnika === 'UCENIK'){
                vm.userInfo.person.kurs = course;
                vm.userInfo.person.status = false;
                vm.student = vm.userInfo.person;
                vm.professor = {};
            }
            var user = vm.userInfo.user;
            var student = vm.student;
            var professor = vm.professor;
            RegistrationService.register({"korisnik":user,"nastavnik":professor,"ucenik":student}).then(function(result){
                var res = result.data;
                $location.path("/signup/success");
            });
        }
    }
})();