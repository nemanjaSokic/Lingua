(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('StudentService', StudentService);

    StudentService.$inject = ['$http'];

    function StudentService($http) {
        return {
            getAll : function (registrated) {
                return $http.get('/api/students/', {params: {'register':registrated}});
            },
            getOne: function(index){
                return $http.get('/api/students/'+index);
            },
            edit: function(student){
                return $http.put('/api/students/'+student.indeks, student);
            },
            delete: function(index){
                return $http.delete('/api/students/'+index);
            }
        }
    }
})();
