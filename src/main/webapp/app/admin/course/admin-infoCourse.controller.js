(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdmiInfoCourseController', AdmiInfoCourseController);

        AdmiInfoCourseController.$inject = ['$scope' ,'loginCheck','courseServ','courseStudent','courseTest','LoginService'];
    function AdmiInfoCourseController($scope ,loginCheck,courseServ,courseStudent,courseTest,LoginService) {
        var vm = this;
         vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.course = courseServ;
        vm.students = courseStudent;
        vm.tests = courseTest; 

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