(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('StudentService', StudentService);

    StudentService.$inject = ['$http'];

    function StudentService($http) {
        return {
            getAll : function () {
                return $http.get('/api/students/');
            },
            getOne: function(index){
                return $http.get('/api/students/'+index);
            }
        }
    }
})();
