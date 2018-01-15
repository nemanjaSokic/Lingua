(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('AdminStudentController', AdminStudentController);

    AdminStudentController.$inject = ['$rootScope', '$scope', 'studentService', 'StudentService', '$log', '$location'];

    function AdminStudentController ($rootScope, $scope, studentService, StudentService, $log, $location) {
        var vm = this;
        vm.student = studentService;
    }
})();
