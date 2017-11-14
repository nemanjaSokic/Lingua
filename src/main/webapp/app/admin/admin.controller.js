(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['$rootScope', '$scope', '$http', '$location', 'LoginService'];

    function AdminController ($rootScope, $scope, $location, AdminService) {
        var vm = this;
        vm.account = $rootScope.account;
    }
})();

  