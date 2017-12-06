(function(){
    "use strict";
    
    var WS_PATH = "http://localhost:8080/SoccerWorldChampionshipRest/world/";

    angular.module('WSChampionshipApp')
    .service("WSChampionshipService", ["$http", function($http){
        this.getAll = function(success, failure){
        	 $http.get(WS_PATH + 'getWSChampionshipList')
             .then(success)
             .catch(failure);
        }
        
    }])
    
})()