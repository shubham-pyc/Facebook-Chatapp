(function() {
    var stompService = function() {

      //------------------------VARIABLES INIT---------------------------------
      const endPoint = "/websocket";
      const serverIp = ip + ":" + port + endPoint;


      //------------------------SCOKET INIT-------------------------------------
      var socket = new SockJS(serverIp);
      var stompClient = Stomp.over(socket);


      //-------------------------FUNCTIONS--------------------------------------

      //FUNCTION FOR JOINNING THE CHAT SERVER
      var join = function(username){
        stompClient.send('/app/chat.addAgent',{},JSON.stringify({
          sender: username,
          type: 'JOIN'
        }))
      }
      //FUNCTION TO SUBSCRIBE TO A CHANNEL
      var subscribe = function(username, func) {
        stompClient.subscribe('/user/' + username + '/reply', func)
      }
      //SEDNING DATA TO THE SERVER
      var send = function(sender,receiver,message){
        if(message && stompClient){
          var chatMessage = {
            sender:sender,
            type:'CHAT',
            message:message,
            receiver:receiver
          };
          stompClient.send('/app/chat.sendToUser',{},JSON.stringify(chatMessage));
        }
      }
      //FINAL CONNECTION WITH THE SERVER
      var connect = function(connectFunction,errorFunction){
        stompClient.connect({},connectFunction,errorFunction);
      }

      return{
        send:send,
        connect:connect,
        subscribe:subscribe,
        join:join
      }

    }

    angular.module('myapp').service('stompService',stompService);

}())
