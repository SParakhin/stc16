<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Admin page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body {
            background: #eeeeee;
        }
        .header {
            padding: 0px 10px 0px 10px;
            margin-bottom: 0px;
        }
        .left-menu {
            background: white;
            padding: 20px 0 0 0;
            min-height: 94vh;
        }
        .left-menu ul li {
            margin: 0px;
        }
        .left-menu ul li a {
            border-radius: 0px;
        }
        .nav-content {
            margin-bottom: -1px;
        }
        .edit-form label {
            font-weight: 100;
            font-size: 20px;
            margin: 10px 0 10px 0;
        }
    </style>

</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="navbar navbar-inverse navbar-static-top header">
            <a class="navbar-brand" href="#">Project name</a>
            <a class="navbar-brand pull-right" href="/logout">Logout</a>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-3 col-md-2 col-xs-2 left-bar left-menu">
            <ul class="nav nav-pills nav-stacked nav-content">
                <li>
                    <a href="/user/updateUserForm">Мой профиль</a>
                </li>
                <li>
                    <a href="#">Мои магазины</a>
                </li>

                <li class="active">
                    <a href="/address/listAddress">Мои адреса доставки</a>

                </li>
            </ul>
        </div>
        <div class="col-lg-9 col-md-10 col-xs-10">
            <h1>Мой профиль</h1>
            <p>Hello ${userAuth.username}!</p>
        </div>
    </div>

</body>
</html>
