<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page-template>
    <jsp:attribute name="titleText">Вход</jsp:attribute>
    <jsp:attribute name="metaDescription">Страница авторизации пользователя</jsp:attribute>
    <jsp:body>

        <div class="row justify-content-center my-3">
            <div class="col col-md-6">
                <c:choose>
                    <c:when test="${isEdit = 'true'}">
                        <c:set var="action" value="edit"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="action" value="save"/>
                    </c:otherwise>
                </c:choose>
                <form:form action="${action}" modelAttribute="cat" method="POST">
                    <form:hidden path="id"/>

                    <span class="h5">Название категории:</span>
                    <form:input class="form-control" path="name"/>
                    <small><form:errors path="name" cssClass="text-danger"/></small>
                    <br/>
                    <span class="h5">url изображения:</span>
                    <form:input class="form-control" path="pictureUrl"/>
                    <small><form:errors path="pictureUrl" cssClass="text-danger"/></small>

                    <br>
                    <input class="btn btn-lg btn-primary my-1" type="submit" value="сохранить"/>
                </form:form>
            </div>
        </div>

    </jsp:body>
</t:page-template>