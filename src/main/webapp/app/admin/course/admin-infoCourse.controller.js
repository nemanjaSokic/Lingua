(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdmiInfoCourseController', AdmiInfoCourseController);

        AdmiInfoCourseController.$inject = ['$scope','CourseService','StudentService','ProfessorService','loginCheck','courseServ','courseStudent','courseTest','LoginService','$location'];
    function AdmiInfoCourseController($scope,CourseService,StudentService,ProfessorService,loginCheck,courseServ,courseStudent,courseTest,LoginService,$location) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.course = courseServ;
        vm.students = courseStudent;
        vm.tests = courseTest; 
        vm.error = {};

        vm.saveCourse = function(){
            if(vm.course.nastavnik === null || typeof vm.course.nastavnik !== 'object'){
                vm.error.text = 'You must select professor!';
                vm.error.show = true;
                return vm.error;
            }
            CourseService.save(vm.course).then(function(res){
                vm.showProfList = false;
                vm.error = {};
            });
        }
        vm.getList = function(id){
            ProfessorService.getListByLanguage(id).then(function(res){
                vm.professors = res.data;
                vm.showProfList = true;
            });
        }

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