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
            getOne: function(id, students){
                return $http.get('/api/courses/'+id);
            },
            getAllCoursesByProfessor: function(id){
                return $http.get('/api/courses/professors/' + id);
            },
            getCourseStudent: function(id){
                return $http.get('/api/courses/'+id+'/students');
            },
            getCourseTests: function(id){
                return $http.get('/api/courses/'+id+'/tests');
            },
            addNewCourse: function(course){
                return $http.post('/api/courses/', course);
            }
        }
    }
})();
