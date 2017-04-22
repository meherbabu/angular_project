(function() {
	var myApp = angular.module("myApp", []);

	myApp.controller('homeController', function($scope, $http) {
		$scope.value = '';
		
		 $http.get('../../Angular_REST_WS/rest/home').then(success, failure);
		 
		 function success(response){
			 console.log(response);
			 $scope.value=response.data.name;
		 }
		 
		 function failure(response){
			 console.log(response);
		 }
	})
}());