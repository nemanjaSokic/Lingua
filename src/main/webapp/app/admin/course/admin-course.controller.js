(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminCourseController', AdminCourseController);

    AdminCourseController.$inject = ['$rootScope', '$scope', 'loginCheck', '$log', '$location'];

    function AdminCourseController ($rootScope, $scope, loginCheck, $log, $location) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        
        
    }
})();
