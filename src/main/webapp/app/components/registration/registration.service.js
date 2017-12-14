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
            professorRegister: function(prof){
                return $http.post('/api/users/prof', prof);
            },
            studentRegister: function(stud){
                return $http.post('/api/users/stud', stud);
            }
        }
    }
})();
