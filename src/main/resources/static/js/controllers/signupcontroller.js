(function(){
  var signupController = function($scope,server,$location){
      $scope.register = function(){

          if($scope.password !== $scope.rpassword){

            alert('passwords do not match');
            return;
          }
          server.register($scope.username,$scope.password).
                then(function(response){
                  alert('successfully registered');
                  $location.path('/index');
                },function(error){
                  alert('user already exists');
                })
      }
      $scope.cancel = function(){
        $location.path('/index');
      }

  }
  angular.module('myapp').controller('signupController',signupController);
}())
