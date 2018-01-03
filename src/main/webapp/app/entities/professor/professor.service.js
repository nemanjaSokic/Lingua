(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('ProfessorService', ProfessorService);

    ProfessorService.$inject = ['$http', '$routeParams'];

    function ProfessorService($http, $routeParams) {
        return {
            getAllProfessor : function(){
                return $http.get('/api/professors');
            },
            getOne: function(id){
                return $http.get('/api/professors/'+id);
            },
            edit: function(professor){
                return $http.put('/api/professors/'+ $routeParams.id,professor);
            },
            delete: function(id){
                return $http.delete('/api/professors/'+id);
            }
        }
    }
})();
