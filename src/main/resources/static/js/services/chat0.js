(function() {
  var app = angular.module("myapp");


  var chat = function($http,stompService) {

    // ----------------variable initilization  starts here---------------------
    var onMessageRecievedFunction = null;
    var username = "default";
    var receiver = null;
    //-----------------setters for the varialbes and functions ----------------

    var setUsername = function(user) {
      username = user;
    }
    var setReceiver = function(gReceiver) {
      receiver = gReceiver;
    }
    var onMessageRecievedFunction = null;

    var setMessageFunction = function(func) {
      onMessageRecievedFunction = func;
    }

    //---------------------CALLBACK functions----------------------------------
    //CALLBACK FOR JOINNING THE CHAT
    var onConnected = function() {
      stompService.join(username);
      stompService.subscribe(username,onMessageRecieved)
    }
    // ERROR HANDELAR
    var onError = function(error) {
      console.log('error found cannot connect to the server');
    }

    //FUNCTION FOR SENDING THE MESSAGE
    var sendMessage = function(message) {
      stompService.send(username,receiver,message)
    }
    // FUNCTION CALLBACK WHEN WE RECEIEVED A MESSAGE
    var onMessageRecieved = function(payload) {
      var message = JSON.parse(payload.body);
      if (message.type === 'CHAT') {
        onMessageRecievedFunction(message);
      }
    }

    //FINAL CONNECTION WITH THE STOMP CLIENT
    stompService.connect(onConnected, onError);


    //RETURN STATEMENT
    return {
      sendMessage: sendMessage,
      setUsername: setUsername,
      setMessageFunction: setMessageFunction,
      setReceiver: setReceiver
    }
  }

  //REGISTERING THE SERVICE
  app.service('chat', chat);


}());
