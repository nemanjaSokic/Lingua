(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('StudentController', StudentController);

    StudentController.$inject = ['$rootScope', '$scope', '$http','$q', '$location'];

    function StudentController ($rootScope, $scope, $http, $q, $location) {
        var vm = this;
        console.log(vm);
    }
})();
