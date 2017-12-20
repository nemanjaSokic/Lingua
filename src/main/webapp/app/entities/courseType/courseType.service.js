(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('CourseTypeService', CourseTypeService);

    CourseTypeService.$inject = ['$http'];

    function CourseTypeService($http) {
        return {
            getAllCourseTypes : function(){
                return $http.get('/api/courseTypes');
            }
        }
    }
})();
