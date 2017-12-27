/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module('crudapp', []);
app.controller('crudctrl', function($scope, $http, $timeout) {
    $scope.success = true;
    $scope.error = true;
    $scope.hideUpdate = true;
    
    $scope.viewalldata = function(){
        $http.post("view")
        .then(function(response) {
                $scope.alldata = response.data;
        });
    };
    $scope.deleteUser = function(id){
        $http({
           url : 'delete',
           method: 'POST',
           data : {'id':id}
        }).then(function(response){
            if(response.status){
                $scope.success = false;
                $scope.successMessage = "User Deleted";
                $scope.viewalldata();
                $timeout(function(){
                    $scope.success = true;
                },5000);
            }
        },function(response) {
            $scope.error = false;
            $scope.errorMessage = "User not Deleted";
            $timeout(function() {
                $scope.error = true;
            }, 5000);
        });
    };
    $scope.fillData = function(userdetails) {
        $scope.user= {};
        $scope.user = angular.copy(userdetails);
        $scope.hideUpdate = false;
        $scope.hideAdd = true;
    };
    $scope.updateUser = function(){
        $http({
           url : 'update',
           method: 'POST',
           data : {'id':$scope.user.id, 'name': $scope.user.name, 'email': $scope.user.email, 'age':$scope.user.age, 'contact':$scope.user.contact, 'city':$scope.user.city}
        }).then(function(response){
            $scope.user= {};
            $scope.hideUpdate = true;
            $scope.hideAdd = false;
            if(response.status){
                $scope.success = false;
                $scope.successMessage = "User Updated";
                $scope.viewalldata();
                $timeout(function(){
                    $scope.success = true;
                },5000);
            }
        },function(response) {
            $scope.error = false;
            $scope.errorMessage = "User not Updated";
            $timeout(function() {
                $scope.error = true;
            }, 5000);
        });
    };
    $scope.addUser = function(){
        $http({
           url : 'add',
           method: 'POST',
           data : {'name':$scope.user.name, 'email':$scope.user.email, 'age':$scope.user.age, 'contact':$scope.user.contact, 'city':$scope.user.city}
        }).then(function(response){
            $scope.user = {};
            if(response.status){
                $scope.success = false;
                $scope.successMessage = "User Added";

                $scope.viewalldata();
                $timeout(function(){
                    $scope.success = true;
                },5000);
            }
        },function(response) {
            $scope.error = false;
            $scope.errorMessage = "User not Added";
            $timeout(function() {
                $scope.errorAdded = true;
            }, 5000);
        });
    };
});