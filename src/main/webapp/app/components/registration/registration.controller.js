(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('RegistrationController', RegistrationController);

    RegistrationController.$inject = ['$rootScope', '$scope', 'langPrepService', 'courseTypePrepService' ,'RegistrationService', '$location'];

    function RegistrationController ($rootScope, $scope, langPrepService, courseTypePrepService, RegistrationService, $location) {
        var vm = this;
        vm.user = {};
        vm.user.telefonKorisnika = 381;
        vm.courseTypes = courseTypePrepService;
        vm.languages = langPrepService;

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
            if(vm.user.tipKorisnika === 'NASTAVNIK'){
                if(vm.profLang != 0){
                    var lang = JSON.parse(vm.profLang);
                    vm.user.predaje = lang;
                    vm.user.napomena = 'My language is ' + lang.naziv + '.';
                }
                var user = vm.user;
                RegistrationService.professorRegister(user).then(function(result){
                    var res = result.data;
                    $location.path("/signup/success");
                });
            }else if(vm.user.tipKorisnika === 'UCENIK'){
                vm.user.status = false;
                if(vm.desiredCourse != 0){
                    var desire = JSON.parse(vm.desiredCourse);
                    vm.user.napomena = 'My desire course is ' + desire.jezik.naziv + ' ' + desire.nivo.nazivNivoa + ' level.';
                }
                var user = vm.user;
               RegistrationService.studentRegister(user).then(function(result){
                    var res = result.data;
                    $location.path("/signup/success");
                });
            }
        }
    }
})();