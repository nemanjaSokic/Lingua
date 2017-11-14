(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

    stateConfig.$inject = ['$routeProvider', '$locationProvider', '$httpProvider'];

    function stateConfig($routeProvider, $locationProvider, $httpProvider) {
        $locationProvider.hashPrefix('');
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
        $routeProvider
            .otherwise({
                redirectTo: '/'
            })
    }
})();
