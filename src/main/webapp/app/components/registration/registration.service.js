(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('RegistrationService', RegistrationService);

    RegistrationService.$inject = ['$http'];

    function RegistrationService($http) {
        return {
            isUsernameExisted : function(username){
                return $http.get('/api/users/'+username);
            },
            getAllCourse : function(){
                return $http.get('/api/courses');
            },
            register: function(user,prof, stud){
                return $http.post('/api/users/user', user);
            }
        }
    }
})();
