(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$rootScope', '$scope', '$http', '$q', '$location', 'LoginService'];

    function LoginController($rootScope, $scope, $http, $q, $location, LoginService) {

        $rootScope.bodyClass = 'loginDiv';

        $scope.credentials = {};
        $scope.login = function() {
            LoginService.logIn($scope.credentials)
                .then(function(response) {
                    var res = response.data;
                    if (res !== '') {
                        if (res.tipKorisnika === 'ADMIN') {
                            $location.path("/admin");
                        } else if (res.registrovan && res.tipKorisnika === 'NASTAVNIK' || res.tipKorisnika === 'UCENIK') {
                            $location.path("/");
                            $scope.error = false;
                        } else {
                            $location.path("/login");
                            $scope.error = true;
                            $scope.errorMessage = 'If you have just signed up, please, check your email and we will response to you soon!';
                        }
                    } else {
                        /*
                                                $rootScope.authenticated = false;*/
                        $scope.error = true;
                    }
                }, function(error) {
                    // handle errors here
                    $scope.errorMessage = error.data.message;
                    $scope.errorStatus = error.data.status;
                    $scope.error = true;
                });
        };
    }
})();