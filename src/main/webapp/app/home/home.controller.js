(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$rootScope', '$scope', '$location'];

    function HomeController($rootScope, $scope, $location) {
        var vm = this;
        $rootScope.bodyClass = 'homeDiv';
    }
})();