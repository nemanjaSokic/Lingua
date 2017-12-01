(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('LoginService', LoginService);

    LoginService.$inject = ['$http'];

    function LoginService($http) {
        return {
            logIn : function (credentials) {
                return $http.get('/api/users/u/' + credentials.username,
                    {headers : 
                        {authorization : "Basic "+ btoa(credentials.username + ":" + credentials.password)}
                });
            },
            logOut : function(){
                return $http.post('/api/users/logout', {});
            },
            check : function(){
                return $http.get('/api/users/u');
            },
            getAll : function(){
                return $http.get('/api/users');
            }
        }
    }
})();
