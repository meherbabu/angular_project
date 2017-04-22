(function() {

	var myApp = angular.module("myApp", [ 'ngResource' ]);

	myApp.service('homeService', function($resource) {
		return $resource('../../rest/home', {}, {
			query : {
				method : 'GET',
				isArray : true,
				cache : true
			}
		});
	});

}());
