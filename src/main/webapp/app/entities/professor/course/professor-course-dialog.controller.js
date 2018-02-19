(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('ProfessorCourseDialogController', ProfessorCourseDialogController );

    ProfessorCourseDialogController.$inject = ['$scope','$routeParams','courses'];
    function ProfessorCourseDialogController   ($scope, $routeParams,courses) {
        var vm = this;
        vm.id = $routeParams.courseId;
        vm.courses = courses;
    } 
})();