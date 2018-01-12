(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdmiInfoCourseController', AdmiInfoCourseController);

        AdmiInfoCourseController.$inject = ['$scope','StudentService','loginCheck','courseServ','courseStudent','courseTest','LoginService','$location'];
    function AdmiInfoCourseController($scope,StudentService,loginCheck,courseServ,courseStudent,courseTest,LoginService,$location) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.course = courseServ;
        vm.students = courseStudent;
        vm.tests = courseTest; 

        vm.showList = function(){
            StudentService.getCourseAssignedStudents(false).then(function(res){
                $scope.unassignedStudents = res.data;
                $scope.showItems = true;
            },
            function(error){
                $scope.showItems = false;
                vm.error = {};
                vm.error.show = true;
                vm.error.text = 'There is no more students!';
            });
        }
        vm.addStudent = function(student){
            student.kurs = vm.course;
            StudentService.edit(student).then(function(res){
                vm.students.push(res.data);
                vm.showList();
                
            });
        };
        
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