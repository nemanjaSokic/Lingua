(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$rootScope', '$scope', '$http','$q', '$location', 'LoginService'];

    function LoginController ($rootScope, $scope, $http, $q, $location, LoginService) {

        $scope.credentials = {};
        $scope.login = function() {
            LoginService.logIn($scope.credentials)
                .then(function(response){
                    var response = response.data;
                    if(response !== ''){
                        $rootScope.account = response.korisnickoIme;
                        $rootScope.role = response.tipKorisnika;
                        $rootScope.authenticated = true;
                        if($rootScope.role === 'ADMIN' && $rootScope.authenticated){
                            $location.path("/admin");
                        }else if ($rootScope.authenticated) {
                            $location.path("/");
                            $scope.error = false;
                        } else {
                            $location.path("/login");
                            $scope.error = true;
                        }
                    } else {
                        $rootScope.authenticated = false;
                        $scope.error = true;
                    }
                },function (error) {
                    // handle errors here
                    $scope.errorMessage = error.data.message;
                    $scope.errorStatus = error.data.status;
                    $scope.error=true;
                });
        };
    }
})();
