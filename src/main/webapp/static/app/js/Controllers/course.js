linguaApp.controller('CourseController', function($scope,$routeParams,courseservice) {
	courseservice.getAll();
});