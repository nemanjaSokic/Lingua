(function () {
    'use strict';

    angular
            .module('linguaApp')
            .factory('LanguageService', LanguageService);

    LanguageService.$inject = ['$http'];

    function LanguageService($http) {
        return {
            getAll : function(){
                return $http.get('/api/languages');
            }
        }
    }
})();
