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

    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/base.css"/>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">Редактирование профиля пользователя</h2>
        <div class="panel panel-info">
            <div class="panel-body">
                <form:form action="updateUser" cssClass="form-horizontal"
                           method="POST" modelAttribute="user">
                <form:hidden path="id"/>

                <div class="form-group">
                    <label for="firstName" class="col-md-3 control-label">Фамилия</label>
                    <div class="col-md-9">
                        <form:input path="firstName" cssClass="form-control"/>
                        <form:errors path="firstName" cssClass="alert"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastName" class="col-md-3 control-label" onerror="null">Имя</label>
                    <div class="col-md-9">
                        <form:input path="lastName" cssClass="form-control"/>
                        <form:errors path="lastName" cssClass="alert"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="col-md-3 control-label">Email</label>
                    <div class="col-md-9">
                        <form:input path="email" cssClass="form-control"/>
                        <form:errors path="email" cssClass="alert"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="phone" class="col-md-3 control-label">Телефон</label>
                    <div class="col-md-9">
                        <form:input path="phone" cssClass="form-control"/>
                        <form:errors path="phone" cssClass="alert"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="login" class="col-md-3 control-label">Логин</label>
                    <div class="col-md-9">
                        <form:input path="login" cssClass="form-control"/>
                        <form:errors path="login" cssClass="alert"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-md-3 control-label">Пароль</label>
                    <div class="col-md-9">
                        <form:input path="password" cssClass="form-control"/>
                        <form:errors path="password" cssClass="alert"/>
                    </div>
                </div>

                <div class="form-group">
                    <!-- Button -->
                    <div class="col-md-offset-3 col-md-9">
                        <form:button cssClass="btn btn-primary">Сохранить данные</form:button>
                    </div>
                </div>
            </div>
            </form:form>

            <form:form action="deleteUser" cssClass="form-horizontal"
                       method="GET" modelAttribute="user">
                <form:hidden path="id"/>
                <div class="form-group">
                    <!-- Button -->
                    <div class="col-md-offset-3 col-md-9">
                        <form:button cssClass="btn btn-primary">Удалить профиль</form:button>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>
</div>
</body>
</html>