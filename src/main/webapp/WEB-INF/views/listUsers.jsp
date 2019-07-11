<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>innobazaar</title>
    <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/base.css"/>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h2>Тестовый список пользователей</h2>

        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Список пользователей</div>
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our users -->
                    <c:forEach var="user" items="${users}">

                        <!-- construct an "update" link with user id -->
                        <c:url var="updateLink" value="/updateUserForm">
                            <c:param name="id" value="${user.id}"/>
                        </c:url>


                        <!-- construct an "delete" link with user id -->
                        <c:url var="deleteLink" value="/deleteUser">
                            <c:param name="id" value="${user.id}"/>
                        </c:url>

                        <c:url var="addressLink" value="/addAddressForm">
                            <c:param name="id" value="${user.id}"/>
                        </c:url>



                        <tr>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.email}</td>

                            <td>
                                <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Вы хотите удалить пользователя?'))) return false">Delete</a>
                                | <a href="${addressLink}">Добавить адрес</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
</body>

</html>









