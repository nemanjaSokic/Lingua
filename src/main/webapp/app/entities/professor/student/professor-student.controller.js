(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('ProfessorStudentController', ProfessorStudentController);

    ProfessorStudentController.$inject = ['$scope','$routeParams','students'];
    function ProfessorStudentController($scope,$routeParams,students) {
        var vm = this;
        vm.students = students;
    }
})();