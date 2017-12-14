(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('RegistrationController', RegistrationController);

    RegistrationController.$inject = ['$rootScope', '$scope', 'coursePrepService' ,'RegistrationService', '$location'];

    function RegistrationController ($rootScope, $scope, coursePrepService, RegistrationService, $location) {
        var vm = this;
        vm.user = {};
        vm.professor = {};
        vm.student = {};
        vm.user.telefonKorisnika = 381;
        vm.courses = coursePrepService;

        $scope.emailTrim = function(u){
            if(vm.user.email && vm.user.email.indexOf("@") != -1){
                vm.user.korisnickoIme = u.substring(0,vm.user.email.indexOf("@"));
                $scope.checkUser();
            }
        }
        $scope.checkPass = function(){
            if($scope.confPass === vm.user.sifraKorisnika && vm.user.sifraKorisnika){
                $scope.confirmMessage = "Good type!";
                return true;
            }else{
                return false;
            }
        }
        $scope.checkUser = function(){
            RegistrationService.isUsernameExisted(vm.user.korisnickoIme).then(function(res){
                var result = res.data;
                $scope.userError = result;
                return result;
            });
        }
        $scope.register = function(){
            vm.user.registrovan = false;
            var course = JSON.parse(vm.course);
            if(vm.user.tipKorisnika === 'NASTAVNIK'){
                vm.professor = vm.user;
                vm.user.predaje = course.nastavnik.predaje;
                var user = vm.user;
                RegistrationService.professorRegister(user).then(function(result){
                    var res = result.data;
                    $location.path("/signup/success");
                });
            }else if(vm.user.tipKorisnika === 'UCENIK'){
                vm.student = vm.user;
                vm.user.kurs = course;
                vm.user.status = false;
                var user = vm.user;
                RegistrationService.studentRegister(user).then(function(result){
                    var res = result.data;
                    $location.path("/signup/success");
                });
            }
        }
    }
})();