(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminCourseController', AdminCourseController);

    AdminCourseController.$inject = ['$rootScope', '$scope','courseServ','loginCheck', '$log', '$location','LoginService'];

    function AdminCourseController ($rootScope, $scope,courseServ,loginCheck, $log, $location,LoginService) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.course = courseServ;
        
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
