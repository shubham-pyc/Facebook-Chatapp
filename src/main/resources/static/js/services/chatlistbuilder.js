  (function(){
  var chatListBuilder = function(){
    //GETTER FUNCTION
    var build = function(){
      return new chatBuilder();
    }
    // OBJECT BUILDER
    function chatBuilder(){
      this.chatTitle = null;
      this.chatList = [];
      return this;
    }

    return{
      build:build
    }
  }
  angular.module('myapp').service('chatListBuilder',chatListBuilder);

}())
