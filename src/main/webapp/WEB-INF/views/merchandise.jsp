<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page-template>
    <jsp:attribute name="titleText">Карточка товара</jsp:attribute>
    <jsp:attribute name="metaDescription">Просмотр товара</jsp:attribute>
    <jsp:body>

        <div class="row my-4">
            <div class="col-12 col-sm-12 col-md-6 col-lg-7">
                <div class="product-item">
                    <img class="img-fluid" src=${merchandiseObject.pictureUrl}>
                    <div class="product-list">
                        <h3>${merchandiseObject.name}</h3>
                        <span class="price">${merchandiseObject.price} руб.</span>
                        <br>
                        <form action="${pageContext.request.contextPath}/addBasket" method="get">
                            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                            <input type="hidden" name="id" value="${merchandiseObject.id}">
                            <input type="submit" class="button" value="Добавить в корзину"/>
                        </form>

                    </div>
                </div>
            </div>
            <div class="col-12 col-sm-12 col-md-6 col-lg-5">
                <h3>Описание:</h3>
                <span class="product">${merchandiseObject.productDetail}</span>
            </div>
        </div>

    </jsp:body>
</t:page-template>