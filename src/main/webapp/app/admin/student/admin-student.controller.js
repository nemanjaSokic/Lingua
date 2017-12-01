(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminStudentController', AdminStudentController);

    AdminStudentController.$inject = ['$rootScope', '$scope', 'loginCheck', '$http','$q', '$location'];

    function AdminStudentController ($rootScope, $scope, loginCheck, $http, $q, $location) {
        var vm = this;
        vm.account = accountService;
        vm.user = accountService;
        vm.isAuth = loginCheck.authenticated;
    }
})();
