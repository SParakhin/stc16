<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Изменение адреса</jsp:attribute>
    <jsp:attribute name="metaDescription">Изменение адреса доставки</jsp:attribute>
    <jsp:body>
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

    </jsp:body>
</t:page-template>
