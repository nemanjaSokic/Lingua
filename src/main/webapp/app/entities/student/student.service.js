(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('StudentService', StudentService);

    StudentService.$inject = ['$http', '$routeParams'];

    function StudentService($http, $routeParams) {
        return {
            getAll : function (registrated) {
                return $http.get('/api/students/'/* , {params: {'register':registrated}} */);
            },
            getOne: function(index){
                return $http.get('/api/students/'+index);
            },
            edit: function(student){
                return $http.put('/api/students/'+ $routeParams.index, student);
            },
            delete: function(index){
                return $http.delete('/api/students/'+index);
            },
            getMarks: function(index){
                return $http.get('/api/students/'+index+'/marks');
            },
            getPayments: function(index){
                return $http.get('/api/students/'+index+'/payments');
            },
            getCourseAssignedStudents: function(assigned){
                return $http.get('/api/students/', {params: {'assigned_course':assigned}});
            }
        }
    }
})();
