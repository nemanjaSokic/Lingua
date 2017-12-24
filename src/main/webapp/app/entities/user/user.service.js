(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('UserService', UserService);

    UserService.$inject = ['$http'];

    function UserService($http) {
        return {
            getAll : function (registrated) {
                return $http.get('/api/users/', {params: {'register':registrated}});
            }
        }
    }
})();
