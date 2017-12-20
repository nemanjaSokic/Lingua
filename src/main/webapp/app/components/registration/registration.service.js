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
            getAllCourseTypes : function(){
                return $http.get('/api/courseTypes');
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
