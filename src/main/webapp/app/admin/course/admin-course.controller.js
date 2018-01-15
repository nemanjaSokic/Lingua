(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminCourseController', AdminCourseController);

    AdminCourseController.$inject = ['$rootScope', '$scope','courseServ', '$log', '$location','$uibModal'];

    function AdminCourseController ($rootScope, $scope,courseServ, $log, $location,$uibModal) {
        var vm = this;
        vm.course = courseServ;
        vm.error = {};

        vm.open = function (size) {
            var modalInstance = $uibModal.open({
                animation: true,
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: 'new_course-dialg.html',
                controller: 'NewCourseController',
                controllerAs: 'vm',
                size: size,
                resolve: {
                    allCourseTypes: function (CourseTypeService){
                        return CourseTypeService.getAllCourseTypes().then(function(res){
                            return res.data;
                        });
                    },
                    professorService: function(ProfessorService){
                        return ProfessorService.getAllProfessor().then(function(res){
                            return res.data;
                        });
                    },
                    studentService: function(StudentService){
                        return StudentService.getCourseAssignedStudents(false).then(function(res){
                            return res.data;
                        },
                        function(error){
                            vm.error.text='There is no students to waiting for a join to course.';
                            return vm.error.is = true;
                        });
                    }
                }
            });
        }
    }
})();
