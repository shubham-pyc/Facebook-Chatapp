(function(){

	var app = angular.module('myapp');
	app.config(function($routeProvider){
		$routeProvider.
			when('/index',{
				templateUrl:'templates/login.html',
				controller:'loginController'
			}).
			when('/signup',{
				templateUrl:'templates/register.html',
				controller:'signupController'
			}).
			when('/chat',{
				templateUrl:'templates/chatbox.html',
				controller:'chatController',
				resolve: {
        "check": function($location,repository) {
          if(repository.getUsername() == null)
          {
            $location.path('/index');
          }
        }
      }}).
			otherwise({
				redirectTo:'/index'
			})
	})
}());
