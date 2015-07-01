angular.module('hello', [ 'ngRoute' ])
  .config(function($routeProvider, $httpProvider) {

	$routeProvider.
	when('/login', {
		templateUrl : 'login.html',
		controller : 'navigation'
	}).
	when('/messages', {
		templateUrl : 'messages.html',
		controller : 'navigation'
	}).
	when('/leds', {
		templateUrl : 'leds.html',
		controller : 'navigation'
	}).
	when('/temperature', {
		templateUrl : 'temperature.html',
		controller : 'navigation'
	}).
	when('/contact', {
		templateUrl : 'contact.html',
		controller : 'navigation'
	}).
	when('/about', {
		templateUrl : 'about.html',
		controller : 'navigation'
	}).
	when('/', {
		templateUrl : 'home.html',
		controller : 'navigation'
	}).

	otherwise('/login');

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

  })
  .controller('home', function($scope, $http) {
    $http.get('/resource/').success(function(data) {
      $scope.greeting = data;
    })
  })
.controller('navigation',
  function($rootScope, $scope, $http, $location) {

  var authenticate = function(credentials, callback) {
    var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
    } : {};

    $http.get('user', {headers : headers}).success(function(data) {
      if (data.name) {
        $rootScope.authenticated = true;
      } else {
        $rootScope.authenticated = false;
      }
      callback && callback();
    }).error(function() {
       $location.path("/login");
      $rootScope.authenticated = false;
      callback && callback();
    });

  }

  authenticate();
  $scope.credentials = {};
  $scope.login = function() {
      authenticate($scope.credentials, function() {
        if ($rootScope.authenticated) {
          $location.path("/");	
          $scope.error = false;
        } else {
          $location.path("/login");
          $scope.error = true;
        }
      });
  };
  
  $scope.logout = function() {
	  $http.post('logout', {}).success(function() {
		    $location.path("/login");

		  $rootScope.authenticated = false;
	  }).error(function(data) {
	    $rootScope.authenticated = false;
	    $location.path("/login");

	  });
	}
});