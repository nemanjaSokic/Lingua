(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/admin/course/dashboard", {
                    templateUrl : 'app/admin/course/course-dashboard.html',
                    controller : 'AdminCourseController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck,
                    }
                })
                .when("/admin/course/:id", {
                    templateUrl : 'app/admin/course/admin-course.html',
                    controller : 'AdminCourseController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck
                    }
                });
        }
        function loginCheck(LoginService, $location){
            return LoginService.check()
                .then(function(result){
                    var res = result.data;
                    if(res !== '' && res.authenticated == true && res.name === 'admin'){
                        return res;
                    }else{
                        $location.path("/login");
                    }
                },function(error){
                    console.log(error.statusText);
                }
            );
        }
})();