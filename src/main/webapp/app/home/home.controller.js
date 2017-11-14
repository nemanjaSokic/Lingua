(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$rootScope', '$scope','$http', 'LoginService', '$location'];

    function HomeController ($rootScope, $scope, $http, LoginService, $location) {
        var vm = this;
        vm.account = $rootScope.account;
        vm.role = $rootScope.role;
        vm.isAuthenticated = $rootScope.authenticated;

        $scope.logout = function() {
            LoginService.logOut()
                .then(function(result){
                    $location.path("/login");
                },function(error){
                    $rootScope.authenticated = false;
                    console.log(error.statusText);
                });
        }

        

    }
})();
