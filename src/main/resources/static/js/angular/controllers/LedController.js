angular.module('hello').controller('LedCtrl', function($scope, $http) {

	$scope.redLed = 0;
	$scope.orangeLed = 0;
	$scope.greenLed = 0;
	$scope.redLedClick = function() {
		
		$scope.redLed = $scope.redLed == 1?0:1;

		if($scope.redLed == 1)
		{
			$http.get('/turnRedOn').success(function(data) {
				console.log("turn red on");
			});
		}
		else
		{
			
			$http.get('/turnRedOff').success(function(data) {
				console.log("turn red off");
			});
		}	

		

	};

	$scope.orangeLedClick = function() {
		$scope.orangeLed = $scope.orangeLed == 1?0:1;
		
		if($scope.orangeLed == 1)
		{
			$http.get('/turnOrangeOn').success(function(data) {
				console.log("turn orange on");
			});
		}
		else
		{
			
			$http.get('/turnOrangeOff').success(function(data) {
				console.log("turn orange off");

			});
		}	

	};

	$scope.greenLedClick = function() {
		$scope.greenLed = $scope.greenLed == 1?0:1;

		if($scope.greenLed == 1)
		{
			$http.get('/turnGreenOn').success(function(data) {
				console.log("turn green on");

			});
		}
		else
		{
			
			$http.get('/turnGreenOff').success(function(data) {
				console.log("turn green off");

			});
		}	
	};
});
