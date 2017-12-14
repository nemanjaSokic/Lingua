(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['$rootScope', '$scope', 'getStudents', 'loginCheck', 'LoginService', '$location'];

    function AdminController ($rootScope, $scope, getStudents,loginCheck, LoginService, $location) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.students = getStudents;
        
        $scope.error = getStudents.error;
        $scope.errorMessage = getStudents.errorMessage;

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