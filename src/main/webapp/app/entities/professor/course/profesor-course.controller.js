(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('ProfessorCourseController', ProfessorCourseController);

    ProfessorCourseController.$inject = ['courses'];

    function ProfessorCourseController (courses) {
        var vm = this;
        vm.courses = courses;
    }
})();
