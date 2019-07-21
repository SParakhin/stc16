<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Профиль пользователя</jsp:attribute>
    <jsp:attribute name="metaDescription">Профиль пользователя</jsp:attribute>
    <jsp:body>
        <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 col-md-2 col-xs-2 left-bar left-menu">
                <ul class="nav nav-pills nav-stacked nav-content">
                    <li>
                        <a href="${pageContext.request.contextPath}/user/updateUserForm">Мой профиль</a>
                    </li>
                    <li>
                        <a href="#">Мои магазины</a>
                    </li>

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/address/listAddress">Мои адреса доставки</a>

                    </li>
                </ul>
            </div>
                <%--<div class="col-lg-9 col-md-10 col-xs-10">--%>
                <%--<p>Привет ${userAuth.username}!</p>--%>
                <%--</div>--%>
        </div>

    </jsp:body>
</t:page-template>
