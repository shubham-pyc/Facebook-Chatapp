(function(){
  var app = angular.module('myapp');

  var loginController = function($scope, server,$location,repository) {
    //LOGIN FUNCTION
    $scope.login = function() {
      server.login($scope.username, $scope.password)
              .then(function(response){
                console.log(response);
                repository.setUsername($scope.username);
                $location.path("/chat");
              },function(error){
                alert('invalid details')
              })

    }
    $scope.signup = function(){
      $location.path('/signup');
    }


  }



  app.controller('loginController', loginController);

}())
