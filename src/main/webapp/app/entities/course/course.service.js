(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('CourseService', CourseService);

    CourseService.$inject = ['$http'];

    function CourseService($http) {
        return {
            getAllCourse : function(){
                return $http.get('/api/courses');
            }
        }
    }
})();
