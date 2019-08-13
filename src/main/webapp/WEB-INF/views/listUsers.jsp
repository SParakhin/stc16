<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Список пользователей</jsp:attribute>
    <jsp:attribute name="metaDescription">Тестовый список пользователей</jsp:attribute>
    <jsp:body>
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
                                <th>Действие</th>
                            </tr>

                            <!-- loop over and print our users -->
                            <c:forEach var="username" items="${users}">

                                <!-- construct an "delete" link with username id -->
                                <c:url var="deleteLink" value="/user/deleteUserFromList">
                                    <c:param name="id" value="${username.id}"/>
                                </c:url>

                                <c:url var="addressLink" value="/address/addAddressForm">
                                    <c:param name="id" value="${username.id}"/>
                                </c:url>


                                <tr>
                                    <td>${username.firstName}</td>
                                    <td>${username.lastName}</td>
                                    <td>${username.email}</td>

                                    <td>
                                        <a href="${deleteLink}"
                                           onclick="if (!(confirm('Вы хотите удалить пользователя?'))) return false">Удалить</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:page-template>









