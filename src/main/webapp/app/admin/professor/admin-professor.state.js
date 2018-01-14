(function() {
    'use strict';

    angular
        .module('linguaApp')
        .config(stateConfig);

        stateConfig.$inject = ['$routeProvider'];

        function stateConfig($routeProvider){
            $routeProvider
                .when("/admin/professor/dashboard", {
                    templateUrl : 'app/admin/professor/professor-dashboard.html',
                    controller : 'AdminProfessorController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck,
                        profService: getProfessors,
                        courses: allProfCourses
                    }
                })
                .when("/admin/professor/:id", {
                    templateUrl : 'app/admin/professor/admin-professor.html',
                    controller : 'AdminInfoProfessorController',
                    controllerAs: 'vm',
                    resolve: {
                        loginCheck: loginCheck,
                        profService: getAccount,
                        courses: profesorsCourse,
                        languages: getLanguages
                    }
                });
        }
        function getLanguages(LanguageService){
            return LanguageService.getAll().then(function(res){
                return res.data;
            })
        }
        function allProfCourses(ProfessorService, CourseService){
            return CourseService.getAllCourse().
                then(function(res){
                    return res.data;
                })
        }

        function profesorsCourse(CourseService, $route){
            return CourseService.getAllCoursesByProfessor($route.current.params.id).
                then(function(result){
                    return result.data;
                })
        }
        function getProfessors(ProfessorService){
            return ProfessorService.getAllProfessor().
                then(function(result){
                    return result.data;
                },function(error){
                    return {error: true,
                            errorMessage: error.data.message
                            }
                });
        }

        function getAccount(ProfessorService, $route){
            return ProfessorService.getOne($route.current.params.id, true).
                then(function(res){
                    return res.data;
                },function(error){
                    return {
                        error: true,
                        errorMessage: error.data.message
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