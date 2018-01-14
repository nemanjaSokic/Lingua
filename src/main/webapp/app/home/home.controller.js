(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$rootScope', '$scope', 'loginCheck', 'LoginService', '$location'];

    function HomeController($rootScope, $scope, loginCheck, LoginService, $location) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        $rootScope.bodyClass = 'homeDiv';

        $scope.logout = function() {
            LoginService.logOut()
                .then(function(result) {
                    $location.path("/login");
                }, function(error) {
                    $rootScope.authenticated = false;
                    console.log(error.statusText);
                });
        }



    }
})();