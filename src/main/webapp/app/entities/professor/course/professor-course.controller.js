(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('ProfessorCourseController', ProfessorCourseController);

    ProfessorCourseController.$inject = ['courses','$rootScope'];

    function ProfessorCourseController (courses,$rootScope) {
        var vm = this;
        vm.courses = courses;
    }
})();
