<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:page-template>
    <jsp:attribute name="titleText">Вход</jsp:attribute>
    <jsp:attribute name="metaDescription">Страница авторизации пользователя</jsp:attribute>
    <jsp:body>

        <c:choose>

            <c:when test="${empty goods}">
                ПУСТО
            </c:when>

            <c:otherwise>

                <c:forEach var="merch" items="${goods}">
                    ${merch.name}
                    <br>
                </c:forEach>

            </c:otherwise>

        </c:choose>

    </jsp:body>
</t:page-template>