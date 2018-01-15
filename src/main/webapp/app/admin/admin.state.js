(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/admin", {
                    templateUrl : 'app/admin/admin.html',
                    controller : 'AdminController',
                    controllerAs: 'vm',
                    resolve: {
                        getUsers: getUnregistratedUsers
                    }
                });
        }

        function getUnregistratedUsers(UserService){
            return UserService.getAll(false).
                then(function(result){
                    return result.data;
                },function(error){
                    return {error: true,
                            errorMessage: error.data.message
                            };
                });
        }
})();