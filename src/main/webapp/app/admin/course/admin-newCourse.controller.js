(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('NewCourseController', NewCourseController);

    NewCourseController.$inject = ['$scope','$uibModalInstance','allCourseTypes','professorService','studentService','CourseService','$location'];
    function NewCourseController($scope,$uibModalInstance,allCourseTypes,professorService,studentService,CourseService,$location) {
        var vm = this;
        vm.types = allCourseTypes;
        vm.profs = professorService;
        vm.studList = studentService;
        vm.course = {};
        vm.course.nastavnik = {};
        vm.course.tipKursa = {};
        
        vm.cancel = function () {
            $uibModalInstance.close();
        };
        vm.cancel();
        vm.selectProf = function(id){
            if(id != undefined){
                vm.filtered=JSON.parse(id);
            }
        }

        vm.confirm = function(){
            var n = JSON.parse(vm.course.nastavnik);
            var tk = JSON.parse(vm.course.tipKursa);
            vm.course.nastavnik = n;
            vm.course.tipKursa = tk;
            CourseService.addNewCourse(vm.course).then(function(res){
                vm.cancel();
                $location.path("/admin/");
            });
        }
    }
})();