(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminInfoStudentController', AdminInfoStudentController);

    AdminInfoStudentController.$inject = ['$scope','$route','loginCheck','studentService','marks','payments','LoginService','StudentService','$location', '$uibModal','UserService'];
    function AdminInfoStudentController($scope,$route,loginCheck,studentService,marks,payments,LoginService,StudentService,$location, $uibModal,UserService) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.student = studentService;
        vm.student.registrovan_temp = vm.student.registrovan;
        vm.error = {
            message: 'default message',
            show: false
        }
        vm.marks = marks;
        vm.payments = payments;
        vm.email = {};

        vm.sendEmail = function(){
            vm.email.to = vm.student.email;
            return UserService.sendEmail(vm.email).then(function(result){
                vm.email = {};
            });
        }
        
        vm.confirmChanges= function () {
            vm.student.registrovan = vm.student.registrovan_temp;
            return StudentService.edit(vm.student).then(function(result){
                $location.path("/admin/student/dashboard");
            }, function(error){
                vm.error.message = 'There is some problem';
                vm.error.show = true;
            });
        }
        vm.delete = function(){
            return StudentService.delete(vm.student.indeks).then(function(result){
                $location.path("/admin/student/dashboard");
            },function(error){
                vm.error.message = 'There is some problem';
                vm.error.show = true;
            })
        }
        vm.open = function (size, parentSelector) {
            var modalInstance = $uibModal.open({
                animation: true,
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: 'assign_course-dialg.html',
                controller: 'AssignCourseCtrl',
                controllerAs: 'vm',
                size: size,
                resolve: {
                    coursePrepService: function (CourseService){
                        return CourseService.getAllCourse().then(function(res){
                            return res.data;
                        });
                    },
                    accountService: function (StudentService, $route){
                        return StudentService.getOne($route.current.params.index).
                            then(function(res){
                                return res.data;
                            },function(error){
                                return {
                                    error: true,
                                    errorMessage: error.data.message
                                }
                            });
                    }
                }
            });
        }
        
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
    angular.module('linguaApp').controller('AssignCourseCtrl', function ($uibModalInstance, accountService, StudentService, coursePrepService, $location,$route) {
        var vm = this;
        vm.allCourses = coursePrepService;
        vm.student = accountService;

        vm.addToCourse = function() {
            return StudentService.edit(vm.student).then(function(result){
                vm.cancel();
                $route.reload();
            });
        };

        vm.cancel = function () {
            $uibModalInstance.close();
        };
    });
})();