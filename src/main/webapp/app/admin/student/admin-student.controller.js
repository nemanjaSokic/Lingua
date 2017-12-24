(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminStudentController', AdminStudentController);

    AdminStudentController.$inject = ['$rootScope', '$scope', '$uibModal', 'accountService', 'loginCheck', 'StudentService', '$log', '$location'];

    function AdminStudentController ($rootScope, $scope, $uibModal, accountService, loginCheck, StudentService, $log, $location) {
        var vm = this;
        vm.account = loginCheck.name;
        vm.isAuth = loginCheck.authenticated;
        vm.student = accountService;

        vm.student.registrovan_temp = vm.student.registrovan;
        
        vm.error = {
            message: 'default message',
            show: false
        }
        vm.confirmChanges= function () {
            vm.student.registrovan = vm.student.registrovan_temp;
            return StudentService.edit(vm.student).then(function(result){
                $location.path("/admin/student/dashbord");
            }, function(error){
                vm.error.message = 'There is some problem';
                vm.error.show = true;
            });
        }
        vm.delete = function(){
            return StudentService.delete(vm.student.indeks).then(function(result){
                $location.path("/admin/student/dashbord");
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
    }
    angular.module('linguaApp').controller('AssignCourseCtrl', function ($uibModalInstance, accountService, StudentService, coursePrepService, $location) {
        var vm = this;
        vm.allCourses = coursePrepService;
        vm.student = accountService;

        vm.addToCourse = function (course) {
            var courseObj = JSON.parse(course);
            vm.student.kurs = courseObj;
            return StudentService.edit(vm.student).then(function(result){
                vm.cancel();
            });
        };

        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
        });
})();
