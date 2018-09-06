(function() {

  var app = angular.module('myapp');

  var chatController =
    function($scope, server, chat, repository, messageOrganizer, chatListBuilder) {
      $('#container').addClass('container-fuild').removeClass('container');

      //---------------------------variable initilization-----------------------
      $scope.chatList = [];
      $scope.messages = [];
      $scope.username = repository.getUsername();


      if (!$scope.username)
        $scope.username = prompt("please enter your username")
      chat.setUsername($scope.username);
      $scope.avatar = server.avatar($scope.username);

      var onMessageRecieved = function(message) {
        $scope.messages.push(message);
        $scope.$apply();
      }
      //if error comes just uncomment the next line;
      //chat.setMessageFunction(onMessageRecieved);

      //------------------------------message functions------------------------
      var addMessage = function(payload) {
        console.log(payload);
        messageOrganizer.addMessage($scope.chatList, payload);
        $scope.$apply();
      }


      chat.setMessageFunction(addMessage);



      $scope.setCurrentChat = function(name) {
        let obj = messageOrganizer.ifChatExists($scope.chatList, name);
        if (obj) {
          $scope.messages = obj.chatList;
          $scope.receiver = name;
          chat.setReceiver($scope.receiver);
          //$scope.$apply();
        }
      }

      // function to send message
      $scope.send = function(event) {
        if (event.key === 'Enter') {
          chat.sendMessage($scope.chatInput);
          $scope.chatInput = '';
        }
      }


      // function to set new receiver
      $scope.setReceiver = function(receiver) {
        console.log("setting username as: " + receiver)
        $scope.receiver = receiver;
        chat.setReceiver($scope.receiver);
        let obj = messageOrganizer.ifChatExists($scope.chatList, $scope.receiver);
        if (!obj) {
          let object = chatListBuilder.build();
          object.chatTitle = $scope.receiver;
          $scope.chatList.push(object);

        }

        $scope.setCurrentChat($scope.receiver);
      }
      //------------------------------css manuplation---------------------------
      $scope.getClass = function(name) {
        if (name === $scope.username) {
          return "sender";
        } else {
          return "receiver";
        }
      }

      $scope.getSelectedClass = function(name) {
        if ($scope.receiver === name) {
          return "selected";
        } else {
          return "unselected";
        }
      }

    }
    //CONTROLLER REGISTRATION
  app.controller('chatController', chatController);
}())
