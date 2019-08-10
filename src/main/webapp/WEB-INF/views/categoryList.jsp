<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page-template>
    <jsp:attribute name="titleText">Вход</jsp:attribute>
    <jsp:attribute name="metaDescription">Страница авторизации пользователя</jsp:attribute>
    <jsp:body>

        <div class="my-3">
            <div class="row my-4">
                <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <span class="h3">Управление категориями товаров</span>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
                    <a href="${pageContext.request.contextPath}/cat/add" class="shadow btn btn-success">+ добавить</a>
                </div>
            </div>
            <c:forEach items="${cats}" var="cat">
                <c:url var="openCatPage" value="${pageContext.request.contextPath}/cat/openWithGoods">
                    <c:param name="catName" value="${cat.value}"/>
                    <c:param name="pageNumber" value="1"/>
                </c:url>
                <div class="row justify-content-center my-3">
                    <div class="col">
                        <div class="btn-group shadow" role="group">
                            <button class="btn btn-primary text-uppercase">${cat.key}</button>
                            <a class="btn btn-outline-dark bg-light" href="${openCatPage}">на страницу</a>
                            <a class="btn btn-warning" href="${pageContext.request.contextPath}/cat/edit">редактировать</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </jsp:body>
</t:page-template>