(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('ProfessorService', ProfessorService);

    ProfessorService.$inject = ['$http'];

    function ProfessorService($http) {
        return {
            getAllProfessor : function(){
                return $http.get('/api/professors');
            },
            getOne: function(id){
                return $http.get('/api/professors/'+id);
            }
        }
    }
})();
