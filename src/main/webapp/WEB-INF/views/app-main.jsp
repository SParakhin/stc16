<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:page-template>
    <jsp:attribute name="titleText">Главная страница</jsp:attribute>
    <jsp:attribute name="metaDescription">Сервис для создания личных магазинов</jsp:attribute>
    <jsp:body>

        <div class="container">
            <br>
            <form:form action="${pageContext.request.contextPath}/search" method="POST">
                <div class="row">
                    <div class="col">
                        <input name="query" class="form-control form-control-lg form-control-borderless"
                               placeholder="Название товара"/>
                    </div>
                    <div class="col-auto">
                        <button class="btn btn-lg btn-success" type="submit">Поиск</button>
                    </div>
                </div>
                <br>
                <c:forEach begin="0" end="${fn:length(categories) > 0 ? fn:length(categories) / 3 - 1 +
                (fn:length(categories) mod 3 == 0 ? 0 : 1) : 0}" items="${categories}"
                           varStatus="i">
                    <div class="row" style="height: 100px">
                        <c:forEach begin="0" end="2" varStatus="j">
                            <c:set var="index" value="${i.index * 3 + j.index}"/>
                            <c:if test="${index < fn:length(categories)}">
                                <div class="col-md-4">
                                    <div class="card h-100">
                                        <label>
                                            <input type="checkbox" name="categoryIds"
                                                   value="${categories[index].id}">${categories[index].name}<br>
                                        </label>
                                        <img src="${categories[index].pictureUrl}" alt="">
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                    <br>
                </c:forEach>
            </form:form>
        </div>

    </jsp:body>
</t:page-template>