(function(){
    "use strict";
    angular.module('WSChampionshipApp',['ngResource'])
        .controller('WSChampionshipController', ['$scope', 'WSChampionshipService', 
          function($scope, WSChampionshipService){     

            WSChampionshipService.getAll(function(response){
            	$scope.data = response.data;            	
            }, function(error){
                console.error("ERROR - WSChampionshipService: ", error);
            });

            $scope.setCurrentCategory = function(category){        
                $scope.currentCategory = category;
            }

            $scope.isCurrentCategory = function(category){
                return $scope.currentCategory.id === category.id;
            }

            $scope.showWindow = function(bookmark){
                $scope.bookmarkForm.$setPristine(); // Elimina el dirty 
                $scope.bookmarkForm.$setUntouched(); // Elimina el toque del campo

                bookmark = bookmark || {category:$scope.currentCategory, url:''};
                $scope.bookmark = bookmark;
                $('#bookmarkModal').modal('show');
            }
        }])
})()