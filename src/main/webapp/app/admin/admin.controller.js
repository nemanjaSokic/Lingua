(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['$rootScope', '$scope', 'getUsers', '$location'];

    function AdminController ($rootScope, $scope, getUsers, $location) {
        var vm = this;
        vm.users = getUsers;
        
        $scope.error = getUsers.error;
        $scope.errorMessage = getUsers.errorMessage;

        

    }
})();