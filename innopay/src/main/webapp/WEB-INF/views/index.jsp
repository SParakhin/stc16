<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Главная страница</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для приёма платежей</jsp:attribute>
    <jsp:body>
        <form method="GET" action="${pageContext.request.contextPath}/registration/registerStore">
            <div class="form-group">
                <label for="storeName">Название магазина</label>
                <input type="text" class="form-control" id="storeName" name="storeName"/>
            </div>
            <button type="submit" class="btn btn-primary">Зарегистрировать</button>
        </form>
    </jsp:body>
</t:page-template>