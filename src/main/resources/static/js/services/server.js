//change name


(function(){
  var server = function($http){
    //LOGIN API CALLING
    var login = function(username,password){
        var obj = {
          "username":username,
          "password":password
        };

        return $http.post(ip+":"+port+"/api/login",obj);

    }
    //REGESTRATION API CALLING
    var register = function(username,password){
      var obj = {
        "username":username,
        "password":password
      };
      return $http.post(ip+":"+port+"/register",obj);

    }
    //GETTING AVATARS FOR THE USERS
    var avatar  = function(username){
      return "https://ui-avatars.com/api/?name="+username;
    }



    //------------------------------------------------ return ------------------------------/
    return{
      login:login,
      register:register,
      avatar:avatar
    }
  }
  angular.module('myapp').service('server',server);
}());
