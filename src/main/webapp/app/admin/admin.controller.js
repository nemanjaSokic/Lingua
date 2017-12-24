(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['$rootScope', '$scope', 'getUsers', 'loginCheck', 'LoginService', '$location'];

    function AdminController ($rootScope, $scope, getUsers, loginCheck, LoginService, $location) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.users = getUsers;
        
        $scope.error = getUsers.error;
        $scope.errorMessage = getUsers.errorMessage;

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