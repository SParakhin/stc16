<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Log in</title>

    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/base.css"/>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link navbar-brand" href="#">InnoBazaar</a>
            </li>
        </ul>
    </div>
    <div class="navbar-collapse collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">О сервисе</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Условия использования</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Контакты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value="/addUserForm"/>">Регистрация</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="<spring:url value="/listUsers"/>">Список пользователей</a>
            </li>
        </ul>
    </div>
</nav>

<section id="welcome">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="wrap-login">
                    <div class="row">
                        <div class="offset-1 col-md-10">
                            <h1 class="text-center">HelloWorld</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
