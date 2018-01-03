(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('CourseService', CourseService);

    CourseService.$inject = ['$http', '$routeParams'];

    function CourseService($http, $routeParams) {
        return {
            getAllCourse : function(){
                return $http.get('/api/courses');
            },
            getAllCoursesByProfessor: function(id){
                return $http.get('/api/courses/professors/' + id);
            }
        }
    }
})();
