(function(){
  var messageOrganizer = function(repository,chatListBuilder){

    //---------------------VAIRABLE INIT----------------------------------------
    var username = repository.getUsername();

    // ADDING MESSAGE TO THE CHAT DATASTRACTURE
    //CHATHISTORY =[CHAT_OBJECT,CHAT_OBJECT]
    //@@CHAT_OBJECT = {
    //@@           CHAT_TITLE:NAME FOR THE CHAT,
    //@@            CHAT_LIST:[MESSAGES,MESSAGES]
    //  }
    //
    //
    var addMessage = function(list,payload){
      if(payload.sender === username){
        //MESSAGE WHICH IS RECEIVED IS SENT BY US
        structureMessage(list,payload,payload.receiver);

      }else{
        structureMessage(list,payload,payload.sender);
      }
    }

    //FUNCTION TO CHECK IF THE SENDER ALREADY HAS A CHAT WITH THE USER
    var ifChatExists = function(list,username){
      for (let i = 0; i < list.length; i++) {
        let obj = list[i];
        if (obj.chatTitle === username) {
          return obj;
        }
      }
      return false;
    }
    var structureMessage = function(list,payload,user){
      let obj = ifChatExists(list,user)
      if(obj){
        //CHAT ALREADY EXISTS JUST PUSH THE MESSAGE
        obj.chatList.push(payload)
      }else{
        //CREATE NEW CHAT DATASTRACTURE AND PUSH MESSAGE IN IT
        let object = chatListBuilder.build();
        object.chatTitle = user;
        object.chatList.push(payload);
        list.push(object);
      }
    }

    return {
      addMessage:addMessage,
      ifChatExists:ifChatExists
    }
  }

  angular.module('myapp').service('messageOrganizer',messageOrganizer);

}())
