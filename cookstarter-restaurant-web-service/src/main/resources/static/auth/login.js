"use strict";

(function () {
    let app = angular.module("myApp");
    // url:  https://cookstarter-users-service.herokuapp.com/auth

    app.controller('loginController', function($scope, $http, $localStorage, $window) {

        // информация для отправки: логин и пароль
        $scope.authInfo={
            username: "",
            password: ""
        };

        $scope.authorisation=function(authInfo){
            console.log(authInfo);

            $http.post("https://cookstarter-users-service.herokuapp.com/auth", authInfo)
                .then(function(response){
                    console.log("Success authenticate");
                    console.log(response);
                    console.log("data.data = " + response.data);
                    console.log("data.data.token = " + response.data.token);
                    // сохраняем токен в localStorage браузера
                    $window.localStorage.setItem('Authorization', 'Bearer ' + response.data.token);
                    // сохраняем в localStorage restaurantId или id пользователя (нужно получить при авторизации)
                    $window.localStorage.setItem('restaurantId', '1');
                    console.log("Проверка при логировании:\n localStorage.getItem: " + $window.localStorage.getItem('Authorization'));
                    console.log("Проверка при логировании:\n restaurantId: " + $window.localStorage.getItem('restaurantId'));

                    // записываем в заголовок полученный токен
                    $http.defaults.headers.common.Authorization = $window.localStorage.getItem('Authorization');
                    $window.location.href = '#/';

                })
                .catch(function(data){
                    console.log("Error authenticate");
                    console.log(data);
                });
        }
    });


})();