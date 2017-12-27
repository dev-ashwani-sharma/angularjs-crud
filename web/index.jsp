<%-- 
    Document   : index
    Created on : Dec 10, 2017, 9:28:51 PM
    Author     : Ashwani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo Application</title>
        <script type="text/javascript" src="./lib/angular.min.js"></script>
        <script type="text/javascript" src="./js/crud_ops.js"></script>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body ng-app="crudapp" ng-controller="crudctrl">
        <h1>User Registration</h1>
        <div class="message" ng-hide="success">{{successMessage}}</div>
        <div class="error message" ng-hide="error">{{errorMessage}}</div>
        
        <form name="userForm">
            <div class="row">
                <span class="label"><label for="name">Name</label></span>
                <span class="input"><input id="name" type="text" ng-model="user.name" required></span>
            </div>
            <div class="row">
                <span class="label"><label for="email">Email ID</label></span>
                <span class="input"><input id="email" type="email" ng-model="user.email" required></span>
            </div>
            <div class="row">
                <span class="label"><label for="Age">Age</label></span>
                <span class="input"><input id="age" type="number" ng-model="user.age" max="100" min="18" required></span>
            </div>
            <div class="row">
                <span class="label"><label for="contact">Contact No</label></span>
                <span class="input"><input id="contact" type="text" ng-model="user.contact" required></span>
            </div>
            <div class="row">
                <span class="label"><label for="city">City</label></span>
                <span class="input"><input id="city" type="text" ng-model="user.city" required></span>
            </div>
            <div class="row">
            <!--<input id="reset" type="submit" value="Reset">-->
                <input id="update" class="submitbuttons button" ng-hide="hideUpdate" type="submit" value="Update" ng-click="updateUser()">
                <input id="add" class="submitbuttons button" ng-hide="hideAdd" type="submit" value="Add" ng-click="addUser()">
            </div>
        </form>
        <div class="datablockcontainer" ng-app="viewalldataapp" ng-init="viewalldata()">
            <div class="datablock">
                <div class="heading tablerow">
                    <span class="tablecol largewidth">Name</span>
                    <span class="tablecol largewidth">Email-ID</span>
                    <span class="tablecol smallwidth">City</span>
                    <span class="tablecol smallwidth">Age</span>
                    <span class="tablecol smallwidth">Contact</span>
                    <span class="tablecol smallwidth">Edit Operation</span>
                    <span class="tablecol smallwidth">Delete Operation</span>
                </div>
                <div class="content tablerow" ng-repeat="x in alldata">
                    <span class="hidden">{{ x.id }}</span>
                    <span class="tablecol largewidth">{{ x.name}}</span>
                    <span class="tablecol largewidth">{{ x.email}}</span>
                    <span class="tablecol smallwidth">{{ x.city}}</span>
                    <span class="tablecol smallwidth">{{ x.age}}</span>
                    <span class="tablecol smallwidth">{{ x.contact}}</span>
                    <span class="tablecol smallwidth" ng-click="fillData(x)"><button class="button">Edit</button></span>
                    <span class="tablecol smallwidth" ng-click="deleteUser(x.id)"><button class="button">Delete</button></span>
                </div>
            </div>
        </div>
    </body>
</html>
