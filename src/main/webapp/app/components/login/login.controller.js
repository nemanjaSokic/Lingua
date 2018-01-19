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
                    $location.path(response.data);
                }, function(error) {
                    // handle errors here
                    $scope.errorMessage = error.data.message;
                    $scope.errorStatus = error.data.status;
                    $scope.error = true;
                });
        };
    }
})();