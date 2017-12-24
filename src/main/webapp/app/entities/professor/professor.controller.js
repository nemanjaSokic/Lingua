(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('ProfessorController', ProfessorController);

    ProfessorController.$inject = ['$rootScope', '$scope', '$http','$q', '$location'];

    function ProfessorController ($rootScope, $scope, $http, $q, $location) {
        var vm = this;
        console.log(vm);
    }
})();
