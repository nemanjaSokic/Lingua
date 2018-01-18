(function() {
    'use strict';

    angular
        .module('linguaApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$rootScope', '$scope', '$location', "bodyClass"];

    function HomeController($rootScope, $scope, $location, bodyClass) {
        var vm = this;
        $rootScope.bodyClass = bodyClass;
        console.log(bodyClass);
    }
})();