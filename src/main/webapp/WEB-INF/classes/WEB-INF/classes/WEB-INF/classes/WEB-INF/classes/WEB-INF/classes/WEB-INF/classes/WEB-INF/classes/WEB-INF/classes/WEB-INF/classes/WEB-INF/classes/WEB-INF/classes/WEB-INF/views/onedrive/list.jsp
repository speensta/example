<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.js"></script>
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" />

</head>
<body>
<h2>board_list</h2>
<div id="jsGrid"></div>

<div id="contents" data-ng-app="application">

    <table border="1" data-ng-controller="appCtrl" data-ng-init="init();">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>작성일자</th>
            <th>조회수</th>
        </tr>

    </table>

    <div class="paging">
            <span><a href=""></a></span>
    </div>

</div>
<script src="/js/common/angularjs/angular.min.js"></script>
<script src="/js/common/angularjs/angular-messages.min.js"></script>
<script src="/js/common/angularjs/angular-message-format.min.js"></script>

<script>
    var appModule = angular.module('application', ['ngMessages']);

    appModule.config(function($compileProvider){
        $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|file|javascript):/);
    });
    (function (module) {
        'use strict';
        var controller = module.controller('appCtrl', function ($scope, $http, $compile, $q) {

            $scope.loadData = function () {

                $http({
                    method: "GET",
                    url: "https://api.onedrive.com/v1.0/shares/u!aHR0cHM6Ly8xZHJ2Lm1zL3UvcyFBcVhQYjFPZnplay1nWDA3SDJ0T2MyLWhtVUFiP2U9VW83VTkx/root?expand=thumbnails",
                    headers: {
                        "Content-Type": "application/json; charset=utf-8"
                    }
                }).then(function (res) {
                    alert(res.data);
                }, function (res) {

                });

            };


            $scope.init = function () {
                $scope.loadData();
            };


        })(appModule);

    });
</script>


</body>
</html>