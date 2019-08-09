<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Карточка товара</jsp:attribute>
    <jsp:attribute name="metaDescription">Просмотр товара</jsp:attribute>
    <jsp:body>
        <div class="card mb-3" style="max-width: 720px;">
            <div class="row no-gutters">
                <div class="col-md-auto">
                    <img src="${merchandiseObject.pictureUrl}" class="card-img" alt="Изображение">
                </div>
                <div class="col-md-auto">
                    <div class="card-body">
                        <h5 class="card-title">${merchandiseObject.name}</h5>
                        <p class="card-text">${merchandiseObject.description}</p>
                        <p class="card-text"><strong>Цена: ${merchandiseObject.price} руб.</strong></p>
                        <br>
                        <form action="${pageContext.request.contextPath}/addBasket" method="get">
                                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                            <input type="hidden" name="id" value="${merchandiseObject.id}">
                            <input type="submit" class="btn btn-success" value="Добавить в корзину"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:page-template>