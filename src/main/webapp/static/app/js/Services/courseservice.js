linguaApp.service('courseservice',['$rootScope','$http','$location',
function($rootScope,$http,$location){
   
    this.getAll = function(){
        $http.get('http://localhost:8080/api/languages/')
            .success(function(data){
                $rootScope.languages = data;
        })
    };
}]);